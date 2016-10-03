package ua.com.sober.getwords.mvp.models.mstranslator;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import java.util.List;

/**
 * Created by dmitry on 10/3/16.
 */

@Root(name = "GetTranslationsArrayRequest")
public class GetTranslationsArrayRequest {

    @Element(name = "AppId", required = false)
    String appId;

    @Element(name = "From", required = false)
    String from;

    @Element(name = "Options", required = false)
    Options options;

    @ElementList(name = "Texts", required = false)
    List<StringWithNamespace> texts;

    @Element(name = "To", required = false)
    String to;

    @Element(name = "MaxTranslations", required = false)
    String maxTranslations;


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


    public List<StringWithNamespace> getTexts() {
        return this.texts;
    }

    public void setTexts(List<StringWithNamespace> _value) {
        this.texts = _value;
    }


    public String getTo() {
        return this.to;
    }

    public void setTo(String _value) {
        this.to = _value;
    }


    public String getMaxTranslations() {
        return this.maxTranslations;
    }

    public void setMaxTranslations(String _value) {
        this.maxTranslations = _value;
    }


    public static class Options {

        @Element(name = "Category", required = false)
        @Namespace(reference = "http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2")
        String category;

        @Element(name = "ContentType", required = false)
        @Namespace(reference = "http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2")
        String contentType;

        @Element(name = "ReservedFlags", required = false)
        @Namespace(reference = "http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2")
        String reservedFlags;

        @Element(name = "State", required = false)
        @Namespace(reference = "http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2")
        int state;

        @Element(name = "Uri", required = false)
        @Namespace(reference = "http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2")
        String uri;

        @Element(name = "User", required = false)
        @Namespace(reference = "http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2")
        String user;


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


        public int getState() {
            return this.state;
        }

        public void setState(int _value) {
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