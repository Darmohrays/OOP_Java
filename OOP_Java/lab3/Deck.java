import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

public class Deck {

    public Card[] cardArr = new Card[36];
    private int remain = 36;

    public Deck() {
        int k = 0;
        for(int i = 0; i < Suit.values.length; i++) {
            for(int j = 0; j < Rank.values.length; j++) {
                cardArr[k] = new Card(Rank.values[j], Suit.values[i]);
                k++;
            }
        }
    }

    public void shuffle() {
        Random rand = new Random();
        for(int i = 0; i < remain; i++) {
            int index = rand.nextInt(remain);
            Card c = cardArr[index];
            cardArr[index] = cardArr[i];
            cardArr[i] = c;
        }

    }

    public void order() {
        CardsComparator comp = new CardsComparator();
        Arrays.sort(cardArr, comp);
    }

    public boolean hasNext() {
        return remain > 0;
    }

    public Card drawOne() {
        if(hasNext()) {
            remain--;
            return cardArr[remain];
        }
        else {
            return null;
        }
    }


    class CardsComparator implements Comparator<Card>{
        @Override
        public int compare(Card a, Card b) {
            String aSuit = a.getSuit().getName();
            String bSuit = b.getSuit().getName();
            String aRank = a.getRank().getName();
            String bRank = b.getRank().getName();
            String[] suits = new String[Suit.values.length];
            for(int i = 0, l = Suit.values.length; i < l; i++) {
                suits[i] = Suit.values[i].getName();
            }
            String[] ranks = new String[Rank.values.length];
            for(int i = 0, l = Rank.values.length; i < l; i++) {
                ranks[i] = Rank.values[i].getName();
            }
            int indexAS = 0, indexBS = 0, indexAR = 0, indexBR = 0;
            for(int i = 0, l = suits.length; i < l; i++) {
                if(Objects.equals(aSuit, suits[i])) {
                    indexAS = i;
                }
                if(Objects.equals(bSuit, suits[i])) {
                    indexBS = i;
                }
            }
            for(int i = 0, l = ranks.length; i < l; i++) {
                if(Objects.equals(aRank, ranks[i])) {
                    indexAR = i;
                }
                if(Objects.equals(bRank, ranks[i])) {
                    indexBR = i;
                }
            }

            if(indexAS > indexBS || indexAS == indexBS && indexAR > indexBR) return 1;
            else if(indexAS < indexBS || indexAS == indexBS && indexAR < indexBR) return -1;
            else return 0;
        }

    }
}