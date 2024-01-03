import java.util.LinkedList;

class BrowserHistory {

    int index = 0;
    LinkedList<String> historyList = new LinkedList<>();

    public BrowserHistory(String homepage) {
        historyList.add(homepage);
    }

    public void visit(String url) {
        index++;
        historyList.add(index, url);

        while(index < historyList.size() - 1) {
            historyList.removeLast();
        }
    }

    public String back(int steps) {
        if (index - steps < 0) {
            index = 0;
            return historyList.getFirst();
        }

        index -= steps;
        return historyList.get(index);
    }

    public String forward(int steps) {
        if (index + steps > historyList.size() - 1) {
            index = historyList.size() - 1;
            return historyList.getLast();
        }

        index += steps;
        return historyList.get(index);
    }
}