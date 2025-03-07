import java.util.Date;

public class ListaTarefas {
    private int id; // Identificador da tarefa
    private String descricao; // Detalhes da tarefas
    private String data; // Data da tarefa, atualize para Date depois
    private String status; // Andamento da tarefa...

    public ListaTarefas() {}

    public ListaTarefas(int id, String descricao, String data, String status) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ListaTarefas{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                ", status='" + status + '\'' +
                '}';
    }

    // Acho que cabe uns métodos de escrever, ou algo do tipo...


}
