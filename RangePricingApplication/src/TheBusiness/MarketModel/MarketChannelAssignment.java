/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.MarketModel;

import TheBusiness.SolutionOrders.SolutionOrder;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class MarketChannelAssignment {

    private Market market;
    private Channel channel;
    private int adbudget;
    //int targetrevenue;
    private ArrayList<SolutionOffer> solutionofferlist;
    private ArrayList<SolutionOrder> solutionorderlist;

    public MarketChannelAssignment(Market m, Channel c) {

        market = m;
        channel = c;
        solutionofferlist = new ArrayList();
        solutionorderlist = new ArrayList();

    }

    MarketChannelAssignment(String channelType, int adBudget) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void addSolutionOffer(SolutionOffer soffer){
        
        getSolutionofferlist().add(soffer);
        
    }    
    public void addSolutionOrder(SolutionOrder so){
        
        getSolutionorderlist().add(so);
        
    }
    
    public int getRevenues(){
        int sum = 0;
        for(SolutionOrder so: getSolutionorderlist()){
            sum = sum + so.getSolutionPrice();
            
        }
        return sum;
    }
    
    public boolean matches(Market m, Channel c) {

        if (getMarket() == m && getChannel() == c) {
            return true;
        } else {
            return false;
        }
    }


    public boolean isMarketMatch(Market m) {

        if (getMarket() == m) {
            return true;
        }
        
        return false;
    }

    public Market getMarket() {
        return market;
    }

    public Channel getChannel() {
        return channel;
    }

    public boolean isChannelMatch(Channel c) {

        if (getChannel() == c) {
            return true;
        }
        return false;
    }

    /**
     * @param market the market to set
     */
    public void setMarket(Market market) {
        this.market = market;
    }

    /**
     * @param channel the channel to set
     */
    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    /**
     * @return the adbudget
     */
    public int getAdbudget() {
        return adbudget;
    }

    /**
     * @param adbudget the adbudget to set
     */
    public void setAdbudget(int adbudget) {
        this.adbudget = adbudget;
    }

    /**
     * @return the solutionofferlist
     */
    public ArrayList<SolutionOffer> getSolutionofferlist() {
        return solutionofferlist;
    }

    /**
     * @param solutionofferlist the solutionofferlist to set
     */
    public void setSolutionofferlist(ArrayList<SolutionOffer> solutionofferlist) {
        this.solutionofferlist = solutionofferlist;
    }

    /**
     * @return the solutionorderlist
     */
    public ArrayList<SolutionOrder> getSolutionorderlist() {
        return solutionorderlist;
    }

    /**
     * @param solutionorderlist the solutionorderlist to set
     */
    public void setSolutionorderlist(ArrayList<SolutionOrder> solutionorderlist) {
        this.solutionorderlist = solutionorderlist;
    }
}
