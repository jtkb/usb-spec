package com.javatechnics.usb.spec;

import java.util.HashMap;
import java.util.Map;

/**
 * Enumeration of USB Descriptor Types.
 * USB 3.0 Specification, Section 9.4 Standard Device Requests, Table 9-6.
 * 
 * @author Kerry Billingham <contact@AvionicEngineers.com>
 */
public enum DescriptorType {
    
    UNKNOWN((byte)0x00),
    DEVICE((byte)0x01),
    CONFIGURATION((byte)0x02),
    STRING((byte)0x03),
    INTERFACE((byte)0x04),
    ENDPOINT((byte)0x05),
    RESERVED_1((byte)0x06),
    RESERVED_2((byte)0x07),
    INTERFACE_POWER((byte)0x08),
    OTG((byte)0x09),
    DEBUG((byte)0x0A),
    INTERFACE_ASSOCIATION((byte)0x0B),
    BOS((byte)0x0F),
    DEVICE_CAPABILITY((byte)0x10),
    SUPERSPEED_USB_ENDPOINT_COMPANION((byte)0x30),
    SUPERSPEEDPLUS_ISOSYNCHRONOUS_ENDPOINT_C_COMPANION((byte)0x33);

    final private byte descriptorType;
    
    private static final Map<Byte, DescriptorType> descriptorTypes = new HashMap<>();
    
    static {
        for (DescriptorType type : DescriptorType.values()){
            descriptorTypes.put(type.descriptorType, type);
        }
    }

    private DescriptorType(byte type) {
        this.descriptorType = type;
    }
    
    public DescriptorType getDescriptorType(byte descriptorType){
        DescriptorType type = UNKNOWN;
        type = descriptorTypes.get(descriptorType);
        if (type == null){
            type = UNKNOWN;
        }
        return type;
    }
    
    public Byte getValue(){
        return descriptorType;
    }
    
}
