public class Ejercicio6 {

    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        NewsChannel channel1 = new NewsChannel("Canal 1");
        NewsChannel channel2 = new NewsChannel("Canal 2");
        Newspaper newspaper = new Newspaper("Diario Nacional");

        agency.addSubscriber(channel1);
        agency.addSubscriber(channel2);
        agency.addSubscriber(newspaper);

        agency.publishNews("Gran descubrimiento científico");

        agency.removeSubscriber(channel2);

        agency.publishNews("Nuevas medidas económicas");
    }
}

class NewsAgency {
    private java.util.List<NewsSubscriber> subscribers = new java.util.ArrayList<>();
    private String latestNews;

    public void addSubscriber(NewsSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(NewsSubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void publishNews(String news) {
        this.latestNews = news;
        notifyAllSubscribers();
    }

    private void notifyAllSubscribers() {
        for (NewsSubscriber subscriber : subscribers) {
            subscriber.update(latestNews);
        }
    }
}

interface NewsSubscriber {
    void update(String news);
}

class NewsChannel implements NewsSubscriber {
    private String name;

    public NewsChannel(String name) {
        this.name = name;
    }

    public void update(String news) {
        System.out.println(name + " reporta: " + news);
    }
}

class Newspaper implements NewsSubscriber {
    private String name;

    public Newspaper(String name) {
        this.name = name;
    }

    public void update(String news) {
        System.out.println(name + " publica: " + news);
    }
}