import java.util.*;
import java.util.HashMap;
import java.util.ArrayList;

public class Account {

    private String name;
    private String nickname;
    private String password;
    private Map<String, Account> friends = new HashMap<String, Account>();
    private ArrayList<String> friend_requests = new ArrayList<String>();
    private Map<String, Community> communitys = new HashMap<String, Community>();
    private ArrayList<Message> messages = new ArrayList<Message>();

    public Account(String name, String nickname, String password)
    {
        this.name = name;
        this.nickname = nickname;
        this.password = password;
    }

    public void printInfo()
    {
        System.out.print("\nCurrent Name: " + this.name + "\n");
        System.out.print("Current Password: " + this.password + "\n");
        System.out.print("Current Nick Name: " + this.nickname + "\n\n");
    }

    public void addFriend(Account friend) { friends.put(friend.getNick(), friend); }

    public boolean haveFriend(String nick)
    {
        return friends.containsKey(nick);
    }

    public boolean haveRequested(String nick)
    {
        return friend_requests.contains(nick);
    }

    public void addRequest(Account friend)
    {
        friend_requests.add(friend.getNick());
    }

    public ArrayList<String> getRequests() { return friend_requests; }

    public void printFriends()
    {
        Set friendsKeys = friends.keySet();
        System.out.print("\nFriends:\n" + friendsKeys + "\n\n");
    }

    public void addMessage(Message message) { messages.add(message); }

    public void checkMessages()
    {
        int i;

        if(messages.isEmpty()) System.out.print("\nNo messages!\n\n");

        for(i=0; i<messages.size(); i++)
        {
            Message message = messages.get(i);

            if(!message.getRead())
            {
                System.out.print(message.getWriter() + ":\n");
                System.out.print(message.getContent() + "\n\n");
                message.read();
            }
        }
    }

    public void printMessages()
    {
        int i;

        if(messages.isEmpty()) System.out.print("\nNo messages!\n\n");

        for(i=0; i<messages.size(); i++)
        {
            Message message = messages.get(i);
            System.out.print(message.getWriter() + ":\n");
            System.out.print(message.getContent() + "\n\n");
        }
    }

    public void addCommunity(Community x){ communitys.put(x.getName(), x); }

    public void removeCommunity(Community x){ communitys.remove(x.getName(), x); }

    public void printCommunitys()
    {
        Set communitysKeys = communitys.keySet();
        System.out.print("\nCommunities:\n" + communitysKeys + "\n\n");
    }

    public void removeFromCommunitys()
    {
        Set comunidades = communitys.keySet();
        Object comunidadeS[] = comunidades.toArray();

        int i;
        for(i=0; i<comunidadeS.length; i++)
        {
            Object CommunityName = comunidadeS[i];
            Community x = communitys.get(CommunityName);
            x.removeMember(this);
        }
    }

    public void removeFriends()
    {
        Set amigos = friends.keySet();
        Object amigoS[] = amigos.toArray();

        int i;
        for(i=0; i<amigoS.length; i++)
        {
            Object FriendName = amigoS[i];
            Account x = friends.get(FriendName);
            x.removeFriend(this);
        }
    }

    public void removeFriend(Account x)
    {
        friends.remove(x.getNick(), x);
    }

    public String getNick()
    {
        return this.nickname;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setNick(String nick)
    {
        this.nickname = nick;
    }
}
