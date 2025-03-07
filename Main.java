public class Main {
    public static void main(String[] args) throws Exception {
        // Adicionando uma tarefa
        TarefaDAO tarefa = new TarefaDAO();
        ListaTarefas tarefas = new ListaTarefas(1, "entregar uma lista de tarefas", "2025-03-07", "Em andamento");
        tarefa.adicionarTarefa(tarefas);

        // Visualizando tudo
        System.out.println(tarefa.listarTarefas());
        // Filtrando a visualização
        System.out.println(tarefa.visualizarUtilizandoCodigo(1));


        // Removendo a tarefa
        // tarefa.deletarTarefa(1);

    }
}