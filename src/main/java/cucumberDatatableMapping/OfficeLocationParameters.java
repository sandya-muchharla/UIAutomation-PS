package cucumberDatatableMapping;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class OfficeLocationParameters {

    private String city;
    private String address;
    private String phoneNumber;

    public OfficeLocationParameters(String city, String address, String phoneNumber){
        this.city = city;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o){
        return EqualsBuilder.reflectionEquals(o, this);
    }

    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
