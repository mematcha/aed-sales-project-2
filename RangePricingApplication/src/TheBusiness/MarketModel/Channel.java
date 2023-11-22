/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.MarketModel;

/**
 *
 * @author kal bugrara
 */
public class Channel {
    private String channeltype; //tv, internet, mobile app..
    private int channelprice;
    private String unitofmeasure;
    public Channel(String t){
        channeltype = t;
    }

    Channel(String type, int price, String unitOfMeasure) {
        channeltype=type;
        channelprice=price;
        unitofmeasure=unitOfMeasure;
    }

    Channel(String channelType, int adBudget) {
        channeltype=channelType;
        channelprice=adBudget;
    }
    public boolean isMatch(String t){
        if (getChanneltype().equalsIgnoreCase(t))return true;
        else return false;
    }
    public String getChannelType( ){
        return getChanneltype();
    }

    /**
     * @return the channeltype
     */
    public String getChanneltype() {
        return channeltype;
    }

    /**
     * @param channeltype the channeltype to set
     */
    public void setChanneltype(String channeltype) {
        this.channeltype = channeltype;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return channelprice;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.channelprice = price;
    }

    /**
     * @return the unitofmeasure
     */
    public String getUnitofmeasure() {
        return unitofmeasure;
    }

    /**
     * @param unitofmeasure the unitofmeasure to set
     */
    public void setUnitofmeasure(String unitofmeasure) {
        this.unitofmeasure = unitofmeasure;
    }

    @Override
    public String toString() {
        return "Channel{" + "channeltype=" + channeltype + ", channelprice=" + channelprice + ", unitofmeasure=" + unitofmeasure + '}';
    }
}
