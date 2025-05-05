package Channels.Model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ChannelTableModel extends AbstractTableModel {
    private String[] columnNames = {"Channel", "Description"};
    private List<Channel> channels;
    public List<Channel> getChannels(){
        return this.channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    public void addChannel(Channel channelToAdd){
        this.channels.add(channelToAdd);
    }
    public ChannelTableModel(List<Channel> channels) {
        this.channels = channels;
    }

    @Override
    public int getRowCount() {
        return channels.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return (Object) channels.get(rowIndex).getChannelName();
            case 1:
                return (Object) channels.get(rowIndex).getDescription();
            default:
                return null;
        }
    }

    //updates column headings from A,B,C to columnNames values
    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }
}