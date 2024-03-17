package Gui;

public class Job {
    private final String line;
    Boolean isFinished;

    public Job(String line) {
        this.line = line;
        this.isFinished = false;
    }
   public String getLine() {
         return this.line;
   }

    public Job(String line, Boolean isFinished) {
        this.line = line;
        this.isFinished = isFinished;
    }

    public void changeStatusDone() {
        isFinished = !isFinished;
    }

    @Override
    public String toString(){
        if (!isFinished) {
            return line + " " + " - On going" + "\n";
        } else {
            return line + " " + " - finished" + "\n";
        }
    }
}

