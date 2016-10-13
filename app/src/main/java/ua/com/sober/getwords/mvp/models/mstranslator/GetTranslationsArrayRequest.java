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

    @Element(name = "AppId")
    private String appId;

    @Element(name = "From")
    private String from;

    @Element(name = "Options", required = false)
    private Options options;

    @Element(name = "Texts")
    private Texts texts;

    @Element(name = "To")
    private String to;

    @Element(name = "MaxTranslations")
    private Integer maxTranslations;


    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }


    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }


    public Options getOptions() {
        return this.options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }


    public Texts getTexts() {
        return this.texts;
    }

    public void setTexts(Texts texts) {
        this.texts = texts;
    }


    public String getTo() {
        return this.to;
    }

    public void setTo(String to) {
        this.to = to;
    }


    public Integer getMaxTranslations() {
        return this.maxTranslations;
    }

    public void setMaxTranslations(Integer maxTranslations) {
        this.maxTranslations = maxTranslations;
    }


    public static class Texts {

        @ElementList(entry = "string", inline = true)
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

        public void setCategory(String category) {
            this.category = category;
        }


        public String getContentType() {
            return this.contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }


        public String getReservedFlags() {
            return this.reservedFlags;
        }

        public void setReservedFlags(String reservedFlags) {
            this.reservedFlags = reservedFlags;
        }


        public Integer getState() {
            return this.state;
        }

        public void setState(Integer state) {
            this.state = state;
        }


        public String getUri() {
            return this.uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }


        public String getUser() {
            return this.user;
        }

        public void setUser(String user) {
            this.user = user;
        }

    }

    @Root(name = "string")
    @Namespace(reference = "http://schemas.microsoft.com/2003/10/Serialization/Arrays")
    public static class StringWithNamespace {

        @Text
        private String string;


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