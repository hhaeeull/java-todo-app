public class Todo{
    private String title;
    private boolean done;

    public Todo(String title){
        this.title = title;
        this.done = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return done;
    }

    public void markDone() {
        this.done = true;
    }

    @Override 
    public String toString() {
        return (done ? "[✔] " : "[ ] ") + title;

    }
}