package org.example.models;

import java.util.List;

public class Mascota {

    private long id;
    private Categoria category;
    private String name;
    private List<String> photoUrls;
    private List<Etiqueta> tags;
    private String status;

    public Mascota() {}

    public Mascota(long id, Categoria category, String name, List<String> photoUrls, List<Etiqueta> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public Categoria getCategory() { return category; }
    public void setCategory(Categoria category) { this.category = category; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<String> getPhotoUrls() { return photoUrls; }
    public void setPhotoUrls(List<String> photoUrls) { this.photoUrls = photoUrls; }

    public List<Etiqueta> getTags() { return tags; }
    public void setTags(List<Etiqueta> tags) { this.tags = tags; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public static class Categoria {

        private int id;
        private String name;

        public Categoria() {}

        public Categoria(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }

    public static class Etiqueta {

        private int id;
        private String name;

        public Etiqueta() {}

        public Etiqueta(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }
}
