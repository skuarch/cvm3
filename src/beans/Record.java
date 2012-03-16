package beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author skuarch
 */
@Entity
@Table(name="t1")
public class Record implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String recordType;
    private String sourceIpAddress = null;
    private String destinationIpAddress = null;
    private String connectionId = null;
    private String calling;
    private String subAddress = null;
    private String disconnectText = null;
    private String connectTime = null;
    private String disconnectTime = null;
    private String origin = null;
    private String chargedUnits = null;
    private String callType = null;
    private String transmitPackets = null;
    private String transmitBytes = null;
    private String receivePackets = null;
    private String receiveBytes = null;
    private String transmitDuration=null;
    private String speechDuration=null;
    private String coderRate=null;
    private String noiseLevel=null;
    private String acomLevel=null;
    private String peerID=null;
    private String logicalIfIndex=null;
    private String remoteIpAddress=null;
    private String roundTripDelay=null;
    private String selectedQos =null;
    private String lostPackets=null;
    private String hiWaterDelay=null;
    private String loWaterDelay=null;
    private String receiveDelay=null;

    //==========================================================================
    public Record() {
    } // end Record  

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public String getCalling() {
        return calling;
    }

    public void setCalling(String calling) {
        this.calling = calling;
    }

    public String getChargedUnits() {
        return chargedUnits;
    }

    public void setChargedUnits(String chargedUnits) {
        this.chargedUnits = chargedUnits;
    }

    public String getConnectTime() {
        return connectTime;
    }

    public void setConnectTime(String connectTime) {
        this.connectTime = connectTime;
    }

    public String getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(String connectionId) {
        this.connectionId = connectionId;
    }

    public String getDestinationIpAddress() {
        return destinationIpAddress;
    }

    public void setDestinationIpAddress(String destinationIpAddress) {
        this.destinationIpAddress = destinationIpAddress;
    }

    public String getDisconnectText() {
        return disconnectText;
    }

    public void setDisconnectText(String disconnectText) {
        this.disconnectText = disconnectText;
    }

    public String getDisconnectTime() {
        return disconnectTime;
    }

    public void setDisconnectTime(String disconnectTime) {
        this.disconnectTime = disconnectTime;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getReceiveBytes() {
        return receiveBytes;
    }

    public void setReceiveBytes(String receiveBytes) {
        this.receiveBytes = receiveBytes;
    }

    public String getReceivePackets() {
        return receivePackets;
    }

    public void setReceivePackets(String receivePackets) {
        this.receivePackets = receivePackets;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getSourceIpAddress() {
        return sourceIpAddress;
    }

    public void setSourceIpAddress(String sourceIpAddress) {
        this.sourceIpAddress = sourceIpAddress;
    }

    public String getSubAddress() {
        return subAddress;
    }

    public void setSubAddress(String subAddress) {
        this.subAddress = subAddress;
    }

    public String getTransmitBytes() {
        return transmitBytes;
    }

    public void setTransmitBytes(String transmitBytes) {
        this.transmitBytes = transmitBytes;
    }

    public String getTransmitPackets() {
        return transmitPackets;
    }

    public void setTransmitPackets(String transmitPackets) {
        this.transmitPackets = transmitPackets;
    }

    public String getAcomLevel() {
        return acomLevel;
    }

    public void setAcomLevel(String acomLevel) {
        this.acomLevel = acomLevel;
    }

    public String getCoderRate() {
        return coderRate;
    }

    public void setCoderRate(String coderRate) {
        this.coderRate = coderRate;
    }

    public String getHiWaterDelay() {
        return hiWaterDelay;
    }

    public void setHiWaterDelay(String hiWaterDelay) {
        this.hiWaterDelay = hiWaterDelay;
    }

    public String getLoWaterDelay() {
        return loWaterDelay;
    }

    public void setLoWaterDelay(String loWaterDelay) {
        this.loWaterDelay = loWaterDelay;
    }

    public String getLogicalIfIndex() {
        return logicalIfIndex;
    }

    public void setLogicalIfIndex(String logicalIfIndex) {
        this.logicalIfIndex = logicalIfIndex;
    }

    public String getLostPackets() {
        return lostPackets;
    }

    public void setLostPackets(String lostPackets) {
        this.lostPackets = lostPackets;
    }

    public String getNoiseLevel() {
        return noiseLevel;
    }

    public void setNoiseLevel(String noiseLevel) {
        this.noiseLevel = noiseLevel;
    }

    public String getPeerID() {
        return peerID;
    }

    public void setPeerID(String peerID) {
        this.peerID = peerID;
    }

    public String getReceiveDelay() {
        return receiveDelay;
    }

    public void setReceiveDelay(String receiveDelay) {
        this.receiveDelay = receiveDelay;
    }

    public String getRemoteIpAddress() {
        return remoteIpAddress;
    }

    public void setRemoteIpAddress(String remoteIpAddress) {
        this.remoteIpAddress = remoteIpAddress;
    }

    public String getRoundTripDelay() {
        return roundTripDelay;
    }

    public void setRoundTripDelay(String roundTripDelay) {
        this.roundTripDelay = roundTripDelay;
    }

    public String getSelectedQos() {
        return selectedQos;
    }

    public void setSelectedQos(String selectedQos) {
        this.selectedQos = selectedQos;
    }

    public String getSpeechDuration() {
        return speechDuration;
    }

    public void setSpeechDuration(String speechDuration) {
        this.speechDuration = speechDuration;
    }

    public String getTransmitDuration() {
        return transmitDuration;
    }

    public void setTransmitDuration(String transmitDuration) {
        this.transmitDuration = transmitDuration;
    }
    
} // end class
