package com.fema.edu.pesqueiro.service;

import com.fema.edu.pesqueiro.infra.enums.ComandaStatus;
import com.fema.edu.pesqueiro.infra.enums.HistComandaStatus;
import com.fema.edu.pesqueiro.infra.model.Cliente;
import com.fema.edu.pesqueiro.infra.model.ClienteComanda;
import com.fema.edu.pesqueiro.infra.model.Comanda;
import com.fema.edu.pesqueiro.infra.model.HistoricoComanda;
import com.fema.edu.pesqueiro.infra.repository.ClienteComandaRepository;
import com.fema.edu.pesqueiro.infra.repository.ComandaRepository;
import com.fema.edu.pesqueiro.infra.repository.HistoricoComandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ComandaService {

    @Autowired
    ClienteComandaRepository repository;

    @Autowired
    ComandaRepository comandaRepo;

    @Autowired
    HistoricoComandaRepository historico;

    @Autowired
    ClienteService clienteService;

    public ClienteComanda findbyComanda(int id){
        Optional<ClienteComanda> comanda = repository.findByComandaId(id);
        return comanda.orElse(null);
    }

    public List<Comanda> findByStatus(ComandaStatus status){
        return comandaRepo.findByStatus(status);
    }

    public List<ClienteComanda> findAll(){
        return repository.findAll();
    }

    public Comanda open(LocalDateTime entrada, UUID cliente_id){
        List<Comanda> disp = findByStatus(ComandaStatus.DISPONIVEL);
        Comanda cmn = new Comanda();

        Cliente cliente = clienteService.findById(cliente_id);

        if(cliente == null){
            throw new RuntimeException("Cliente inexistente!");
        }

        if(disp.isEmpty()){
            cmn.setStatus(ComandaStatus.ABERTA);
        }else{
            cmn = disp.get(0);
            cmn.setStatus(ComandaStatus.ABERTA);
        }
        comandaRepo.save(cmn);

        ClienteComanda comanda = new ClienteComanda(null, 0, entrada, null, cmn);
        repository.save(comanda);

        cliente.setClienteComanda(comanda);
        clienteService.update(cliente);

        return cmn;
    }

    public ClienteComanda updateGasto(float valor, UUID id){
        Optional<ClienteComanda> result = repository.findById(id);
        if(result.isPresent()){
            ClienteComanda comanda = result.get();

            float old = comanda.getGasto();
            comanda.setGasto(old + valor);

            repository.save(comanda);

            return comanda;
        }else{
            throw new RuntimeException("Comanda inexistente!");
        }
    }

    public void close(LocalDateTime saida, HistComandaStatus status, String nota, UUID cliente_id, boolean release){
        Cliente cliente = clienteService.findById(cliente_id);

        if(cliente == null){
            throw new RuntimeException("Cliente inexistente!");
        }

        ClienteComanda comanda = cliente.getClienteComanda();

        if(comanda != null){
            Comanda cmn = comanda.getComanda();

            if(release){
                cmn.setStatus(ComandaStatus.DISPONIVEL);

                HistoricoComanda hist = new HistoricoComanda();

                hist.setNota(nota);
                hist.setEntrada(comanda.getEntrada());
                hist.setSaida(saida);
                hist.setStatus(status);
                hist.setCpf(cliente.getCpf());
                hist.setValor(comanda.getGasto());

                historico.save(hist);

                repository.delete(comanda);
                cmn.setStatus(ComandaStatus.DISPONIVEL);
            }else{
                cmn.setStatus(ComandaStatus.FECHADA);
                comanda.setSaida(saida);
                repository.save(comanda);
            }

            comandaRepo.save(cmn);
        }
    }

    public List<HistoricoComanda> findAllHistory(){
        return historico.findAll();
    }

    public List<HistoricoComanda> findHistoryByCpf(String cpf){
        return historico.findByCpf(cpf);
    }
}
