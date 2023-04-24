package bean;

/**
 * Spring Bean 特殊值处理
 */
public class SpecialValue {

    /**
     * 1 字面量赋值
     */
    private String normal;
    /**
     * 2 null值
     */
    private String nullValue;
    /**
     * 3 xml实体
     */
    private String xmlEntity;
    /**
     * 4 CDATA节
     */
    private String cdataValue;

    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }

    public String getNullValue() {
        return nullValue;
    }

    public void setNullValue(String nullValue) {
        this.nullValue = nullValue;
    }

    public String getXmlEntity() {
        return xmlEntity;
    }

    public void setXmlEntity(String xmlEntity) {
        this.xmlEntity = xmlEntity;
    }

    public String getCdataValue() {
        return cdataValue;
    }

    public void setCdataValue(String cdataValue) {
        this.cdataValue = cdataValue;
    }

    @Override
    public String toString() {
        return "SpecialValue{" +
                "normal='" + normal + '\'' +
                ", nullValue='" + nullValue + '\'' +
                ", xmlEntity='" + xmlEntity + '\'' +
                ", cdataValue='" + cdataValue + '\'' +
                '}';
    }
}
