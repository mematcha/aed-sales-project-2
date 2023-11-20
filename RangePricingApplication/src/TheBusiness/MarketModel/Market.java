/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.MarketModel;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class Market {

    private String name;
        private String submarketType; // New attribute to store the submarket type

    private ArrayList<Channel> validchannels;
    private ArrayList<String> characteristics; //a way to describe in plain language what is that group
    private ArrayList<Market> submarkets;
    private ArrayList<MarketChannelAssignment> channelMappings = new ArrayList<>();
    private int size;

    public Market(String m) {
        name = m;
        characteristics = new ArrayList();
        submarkets = new ArrayList();
        validchannels = new ArrayList();
    }

    public void addCharactersitic(String c) {
        getCharacteristics().add(c);
    }

    public void addValidChannel(Channel c) {

        getValidchannels().add(c);
    }
 public void setSubmarketType(String submarketType) {
        this.submarketType = submarketType;
    }

    // New method to get the submarket type
    public String getSubmarketType() {
        return submarketType;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the validchannels
     */
    public ArrayList<Channel> getValidchannels() {
        return validchannels;
    }

    /**
     * @param validchannels the validchannels to set
     */
    public void setValidchannels(ArrayList<Channel> validchannels) {
        this.validchannels = validchannels;
    }
    
    public void addSubmarket(Market submarket) {
        submarkets.add(submarket);
    }

    /**
     * @return the characteristics
     */
    public ArrayList<String> getCharacteristics() {
        return characteristics;
    }

    /**
     * @param characteristics the characteristics to set
     */
    public void setCharacteristics(ArrayList<String> characteristics) {
        this.characteristics = characteristics;
    }

    /**
     * @return the submarkets
     */
    public ArrayList<Market> getSubmarkets() {
        return submarkets;
    }

    /**
     * @param submarkets the submarkets to set
     */
    public void setSubmarkets(ArrayList<Market> submarkets) {
        this.submarkets = submarkets;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    public void addMarketChannelMapping(String channelType, int adBudget) {
        MarketChannelAssignment mapping = new MarketChannelAssignment(channelType, adBudget);
        getChannelMappings().add(mapping);
    }

    /**
     * @return the channelMappings
     */
    public ArrayList<MarketChannelAssignment> getChannelMappings() {
        return channelMappings;
    }

    /**
     * @param channelMappings the channelMappings to set
     */
    public void setChannelMappings(ArrayList<MarketChannelAssignment> channelMappings) {
        this.channelMappings = channelMappings;
    }

    /**
     * @return the marketChannelAssignment
     */
    
    
    

}
