/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.MarketModel;

import TheBusiness.MarketModel.Market;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class MarketCatalog {

    private ArrayList<Market> markets;

    public MarketCatalog() {
        markets = new ArrayList();
    }

    public void addMarket(Market market) {
        getMarkets().add(market);
}

    public MarketCatalog(String marketName) {
        markets = new ArrayList();
        newMarket(marketName);
    }

    public Market newMarket(String m) {
        Market market = new Market(m);
        getMarkets().add(market);
        return market;
    }

    /**
     * @return the markets
     */
    public ArrayList<Market> getMarkets() {
        return markets;
    }

    /**
     * @param markets the markets to set
     */
    public void setMarkets(ArrayList<Market> markets) {
        this.markets = markets;
    }


}
