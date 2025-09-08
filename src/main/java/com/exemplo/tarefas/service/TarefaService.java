package com.exemplo.tarefas.service;

import com.exemplo.tarefas.model.Tarefa;
import com.exemplo.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    // Listar todas as tarefas
    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    // Buscar tarefa por ID
    public Tarefa buscarPorId(Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        return tarefa.orElseThrow(() -> new RuntimeException("Tarefa não encontrada com ID: " + id));
    }

    // Salvar nova tarefa
    public Tarefa salvar(Tarefa tarefa) {
        // Validações adicionais podem ser implementadas aqui
        validarTarefa(tarefa);
        return tarefaRepository.save(tarefa);
    }

    // Atualizar tarefa existente
    public Tarefa atualizar(Long id, Tarefa tarefaAtualizada) {
        Tarefa tarefaExistente = buscarPorId(id);

        // Atualizar apenas os campos não nulos
        if (tarefaAtualizada.getNome() != null) {
            tarefaExistente.setNome(tarefaAtualizada.getNome());
        }
        if (tarefaAtualizada.getDataEntrega() != null) {
            tarefaExistente.setDataEntrega(tarefaAtualizada.getDataEntrega());
        }
        if (tarefaAtualizada.getResponsavel() != null) {
            tarefaExistente.setResponsavel(tarefaAtualizada.getResponsavel());
        }

        validarTarefa(tarefaExistente);
        return tarefaRepository.save(tarefaExistente);
    }

    // Deletar tarefa
    public void deletar(Long id) {
        if (!tarefaRepository.existsById(id)) {
            throw new RuntimeException("Tarefa não encontrada com ID: " + id);
        }
        tarefaRepository.deleteById(id);
    }



    // Validações da tarefa
    private void validarTarefa(Tarefa tarefa) {
        if (tarefa.getNome() == null || tarefa.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da tarefa é obrigatório");
        }
        if (tarefa.getDataEntrega() == null) {
            throw new IllegalArgumentException("Data de entrega é obrigatória");
        }
        if (tarefa.getResponsavel() == null || tarefa.getResponsavel().trim().isEmpty()) {
            throw new IllegalArgumentException("Responsável é obrigatório");
        }

        // Validar se a data de entrega não é muito antiga
        if (tarefa.getDataEntrega().isBefore(LocalDate.now().minusYears(1))) {
            throw new IllegalArgumentException("Data de entrega não pode ser anterior a um ano");
        }
    }
}