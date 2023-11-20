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
public class ChannelCatalog {

    /**
     * @return the channellist
     */
    public ArrayList<Channel> getChannellist() {
        return channellist;
    }

    /**
     * @param channellist the channellist to set
     */
    public void setChannellist(ArrayList<Channel> channellist) {
        this.channellist = channellist;
    }
    private ArrayList<Channel> channellist ;
    public ChannelCatalog(){
    channellist = new ArrayList();
    }
    
     public void addChannel(Channel channel) {
        if (channel != null) {
            getChannellist().add(channel);
        }
     }
     
   public Channel newChannel(String type, int price, String unitOfMeasure) {
        Channel channel = new Channel(type, price, unitOfMeasure);
        getChannellist().add(channel);
        return channel;
    }
    
    public Channel findChannel(String type){
        
        for( Channel c: getChannellist() ){
            
            if (c.getChannelType().equalsIgnoreCase(type)) return c;
            
        }
        return null; //not found
    }
    
    
}
