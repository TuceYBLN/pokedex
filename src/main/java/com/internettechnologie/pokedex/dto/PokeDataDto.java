package com.internettechnologie.pokedex.dto;

import java.util.List;

public class PokeDataDto {

    private Long id;
    private Integer dex;
    private String nameDe;
    private String nameEn;
    private String nameFr;
    private String nameJa;
    private String nameKr;
    private String nameZh;
    private String family;
    private List<String> types;
    private Boolean shiny;
    private String variant;
    private String image;
    private String region;

    public PokeDataDto(Long id, Integer dex, String nameDe, String nameEn, String nameFr, String nameJa, String nameKr, String nameZh, String family, List<String> types, Boolean shiny, String variant, String image, String region) {
        this.id = id;
        this.dex = dex;
        this.nameDe = nameDe;
        this.nameEn = nameEn;
        this.nameFr = nameFr;
        this.nameJa = nameJa;
        this.nameKr = nameKr;
        this.nameZh = nameZh;
        this.family = family;
        this.types = types;
        this.shiny = shiny;
        this.variant = variant;
        this.image = image;
        this.region = region;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(Integer dex) {
        this.dex = dex;
    }

    public String getNameDe() {
        return nameDe;
    }

    public void setNameDe(String nameDe) {
        this.nameDe = nameDe;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameFr() {
        return nameFr;
    }

    public void setNameFr(String nameFr) {
        this.nameFr = nameFr;
    }

    public String getNameJa() {
        return nameJa;
    }

    public void setNameJa(String nameJa) {
        this.nameJa = nameJa;
    }

    public String getNameKr() {
        return nameKr;
    }

    public void setNameKr(String nameKr) {
        this.nameKr = nameKr;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public List<String>  getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Boolean getShiny() {
        return shiny;
    }

    public void setShiny(Boolean shiny) {
        this.shiny = shiny;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
