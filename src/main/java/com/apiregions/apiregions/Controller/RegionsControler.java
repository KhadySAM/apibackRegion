package com.apiregions.apiregions.Controller;

import com.apiregions.apiregions.Message.ReponseMessage;
import com.apiregions.apiregions.Models.Pays;
import com.apiregions.apiregions.Models.Regions;
import com.apiregions.apiregions.Repository.RegionsRepository;
import com.apiregions.apiregions.Sevices.RegionsService;
import com.apiregions.apiregions.img.ConfigImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/projet/odk/Regions", name = "Regions")
@CrossOrigin
public class RegionsControler {

    @Autowired
    RegionsService regionsService;
//Classe d'ajout des regions

    @PostMapping(path = "/creer", name = "create")
    @ResponseStatus(HttpStatus.CREATED)
    //@PreAuthorize("hasRole('ADMIN')")
    public ReponseMessage add(@RequestBody Regions regions) {
        return this.regionsService.ajouterRegions(regions);
    }

   // ICI ON TENTE DE CREER UNE REGION AVEC IMAGES
   private String nomregions;
    @Column(unique = true)
    private String coderegion;
    private String activiterregion;
    private String superficieregion;
    private String languemregion;
    private String images;
    private String description;
    private int nombrecommentaire;
    @Autowired
    private RegionsRepository regionsRepository;

    @PostMapping("/ajouterRegion")
    public ReponseMessage ajouterRegion(@Param("nomregions") String nomregions,@Param("coderegion") String coderegion, @Param("activiterregion") String activiterregion, @Param("superficieregion") String superficieregion, @Param("languemregion") String languemregion, @Param("habitant") Long habitant, @Param("id_pays") Pays id_pays, @Param("file") MultipartFile file) throws IOException {
        Regions regions = new Regions();
        String nomfile = StringUtils.cleanPath(file.getOriginalFilename());

        System.out.println(nomregions);
        regions.setNomregions(nomregions);

        System.out.println(coderegion);
        regions.setCoderegion(coderegion);

//        System.out.println(nombrecommentaire);
//        regions.setNombrecommentaire(Integer.parseInt(nombrecommentaire));

        System.out.println(activiterregion);
        regions.setActiviterregion(activiterregion);

        System.out.println(nomfile);
        regions.setImages(nomfile);

        System.out.println(nomregions);
        regions.setNomregions(nomregions);

        System.out.println(languemregion);
        regions.setLanguemregion(languemregion);

        System.out.println(superficieregion);
        regions.setSuperficieregion(superficieregion);

        System.out.println(nombrecommentaire);
        regions.setNombrecommentaire(0);

        System.out.println(habitant);
        regions.setHabitant(habitant);

        regions.setPays(id_pays);
        System.out.println(regions.getId_regions());
        System.out.println(regions.getNomregions());


        if(regionsRepository.findByNomregions(nomregions) == null){


            String uploaDir = "C:/Users/kssamake/Desktop/FrontGestionRegion/src/assets/Images";

            ConfigImage.saveimg(uploaDir, nomfile, file);

            return regionsService.ajouterRegions(regions);
        }else {
            ReponseMessage message = new ReponseMessage("Regions existe déja",false);
            return message;
        }

    }


//Classe afficher toute les regions
    @GetMapping(path = "/liste", name = "list")
    @ResponseStatus(HttpStatus.OK) //Permet de monter l'etat de notre requete
    public List<Regions> list() {

      return this.regionsService.afficherRegions();
    }
//Classe afficher une regions kadidia


    @GetMapping(path = "/uneRegion/{id_regions}", name = "lire")
    @ResponseStatus(HttpStatus.OK)
    public ReponseMessage lire(@PathVariable Long id_regions) {
        return this.regionsService.afficherUneRegion(id_regions);
    }
//Classe permettant de modifier les regions

    @PutMapping(path = "/modifier/{id_regions}", name = "modifier")
    @ResponseStatus(HttpStatus.OK)
    public ReponseMessage modifier(@RequestBody Regions regions, @PathVariable Long id_regions) {
        return this.regionsService.modifierRegions(regions, id_regions);
    }

    //Classe permettant de supprimer une region
    @DeleteMapping(path = "/supprimer/{id_regions}", name = "supprimer")
    //  @ResponseStatus(HttpStatus.NO_CONTENT)
    public void supprimer(@PathVariable Long id_regions) {
        this.regionsService.supprimer(id_regions);
    }

    // La liste des regions sans pays

    @GetMapping(path = "/regionssansPays")
    public Iterable<Object[]> mesRegions() {
        return this.regionsService.mesRegions();
    }


    // La liste des regions avec pays

    @GetMapping(path = "/regionsavecPays")
    public Iterable<Object[]> mesRegionsAvecPays() {
        return this.regionsService.mesRegionsAvecPays();
    }



}

