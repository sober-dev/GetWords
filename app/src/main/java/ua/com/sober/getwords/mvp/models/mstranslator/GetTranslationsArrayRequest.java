package ua.com.sober.getwords.mvp.models.mstranslator;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import java.util.List;

/**
 * Created by dmitry on 10/3/16.
 */

@Root(name = "GetTranslationsArrayRequest")
@Order(elements = {"AppId", "From", "Options", "Texts", "To", "MaxTranslations"})
public class GetTranslationsArrayRequest {

    @Element(name = "AppId", required = false)
    private String appId;

    @Element(name = "From", required = false)
    private String from;

    @Element(name = "Options", required = false)
    private Options options;

    @Element(name = "Texts", required = false)
    private Texts texts;

    @Element(name = "To", required = false)
    private String to;

    @Element(name = "MaxTranslations", required = false)
    private Integer maxTranslations;


    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String _value) {
        this.appId = _value;
    }


    public String getFrom() {
        return this.from;
    }

    public void setFrom(String _value) {
        this.from = _value;
    }


    public Options getOptions() {
        return this.options;
    }

    public void setOptions(Options _value) {
        this.options = _value;
    }


    public Texts getTexts() {
        return this.texts;
    }

    public void setTexts(Texts _value) {
        this.texts = _value;
    }


    public String getTo() {
        return this.to;
    }

    public void setTo(String _value) {
        this.to = _value;
    }


    public Integer getMaxTranslations() {
        return this.maxTranslations;
    }

    public void setMaxTranslations(Integer _value) {
        this.maxTranslations = _value;
    }

    public static class Texts {
        @ElementList(name = "string", required = false, inline = true)
        private List<StringWithNamespace> texts;

        public List<StringWithNamespace> getTexts() {
            return texts;
        }

        public void setTexts(List<StringWithNamespace> texts) {
            this.texts = texts;
        }
    }

    public static class Options {
        @Element(name = "Category", required = false)
        @Namespace(reference = "http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2")
        private String category;

        @Element(name = "ContentType", required = false)
        @Namespace(reference = "http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2")
        private String contentType;

        @Element(name = "ReservedFlags", required = false)
        @Namespace(reference = "http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2")
        private String reservedFlags;

        @Element(name = "State", required = false)
        @Namespace(reference = "http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2")
        private Integer state;

        @Element(name = "Uri", required = false)
        @Namespace(reference = "http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2")
        private String uri;

        @Element(name = "User", required = false)
        @Namespace(reference = "http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2")
        private String user;


        public String getCategory() {
            return this.category;
        }

        public void setCategory(String _value) {
            this.category = _value;
        }


        public String getContentType() {
            return this.contentType;
        }

        public void setContentType(String _value) {
            this.contentType = _value;
        }


        public String getReservedFlags() {
            return this.reservedFlags;
        }

        public void setReservedFlags(String _value) {
            this.reservedFlags = _value;
        }


        public Integer getState() {
            return this.state;
        }

        public void setState(Integer _value) {
            this.state = _value;
        }


        public String getUri() {
            return this.uri;
        }

        public void setUri(String _value) {
            this.uri = _value;
        }


        public String getUser() {
            return this.user;
        }

        public void setUser(String _value) {
            this.user = _value;
        }

    }

    @Root(name = "string")
    @Namespace(reference = "http://schemas.microsoft.com/2003/10/Serialization/Arrays")
    public static class StringWithNamespace {

        @Text
        private String string = null;

        public StringWithNamespace(String string) {
            this.string = string;
        }

        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }
    }

}