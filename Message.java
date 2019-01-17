public class Message {

    private Account writer;
    private Account receiver;
    private Community receiverC;
    private String content;
    private boolean read;

    public Message(Account writer, Account receiver, String content)
    {
        this.writer = writer;
        this.receiver = receiver;
        this.content = content;
        this.read = false;
    }

    public Message(Account writer, Community receiverC, String content)
    {
        this.writer = writer;
        this.receiverC = receiverC;
        this.content = content;
    }

    public void read()
    {
        this.read = true;
    }

    public boolean getRead()
    {
        return this.read;
    }

    public String getWriter()
    {
        return writer.getNick();
    }

    public String getContent()
    {
        return this.content;
    }
}
