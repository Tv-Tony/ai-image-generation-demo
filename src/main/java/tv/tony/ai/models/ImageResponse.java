package tv.tony.ai.models;

import java.util.List;

public class ImageResponse {
    private long created;
    private List<UrlResponse> data;

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public List<UrlResponse> getData() {
        return data;
    }

    public void setData(List<UrlResponse> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ImageResponse{" +
                "created=" + created +
                ", data=" + data +
                '}';
    }

    public static class UrlResponse{
        private String url;

        @Override
        public String toString() {
            return "UrlResponse{" +
                    "url='" + url + '\'' +
                    '}';
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
