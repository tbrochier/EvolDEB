package evolution;

public class Humboldt extends Dataset_EVOL {

    public Humboldt() {
       
        // INITIALISATION DU FICHIER CONFIG :
        util.Lire_configuration param_config = new util.Lire_configuration();
        try {
            String fichier_config = System.getProperty("user.dir") + "/" + IBM.config_file;
            util.Lire_configuration.Setup(fichier_config);
        } catch (Exception e) {
// TODO Auto-generated catch block
            System.out.println("probleme dans initialisation du fichier config : " + e.getMessage());
            e.printStackTrace();
        }

        // Lecture du fichier config :
        try {
            //region = "PERU_actuel_moyenne";
            // PERU_PISCES_sixieme , PERU_sixieme , PERU_neuvieme, PERU_preindus, PERU_4xCO2, PERU_actuel, PERU (ex PERU_INTERVINCENT_CLIMPIERRICK)
            // Pour la grille roms Peru10,  1 maille =9km (1/9°)
            // Pool de sorties hydro : (A) 4 ans de Climato Pierrick, year 12-15
            //                         (B) 8 ans de Interanuel Vincent, 1992-2000

            region = param_config.getConfig_string("region");
            //System.out.println ("region = " + region);

            SIMU = param_config.getConfig_int("SIMU");

            ////CONDITIONS INITIALES //////
            // Cette zone doit largement englober la zone de ponte
            // --> ou alors rajouter automatiquement un "sponge" dans Population
            lat_min = param_config.getConfig_double("lat_min");
            lat_max = param_config.getConfig_double("lat_max");
            lon_min = param_config.getConfig_double("lon_min");
            lon_max = param_config.getConfig_double("lon_max");
            bathy_max = param_config.getConfig_int("bathy_max");

            prof_ponte_min = param_config.getConfig_int("prof_ponte_min"); //  PROFONDEUR DE PONTE INITIALE MAX
            prof_ponte_max = param_config.getConfig_int("prof_ponte_max");//  PROFONDEUR DE PONTE INITIALE MIN

            // Profondeur du talu continental (pour le critere de retention)
            prof_talu = param_config.getConfig_int("prof_talu"); // [metres]

            // SPONGE ou TAMPON : distance en km entourant la zone de ponte, tel que les individu ne puissent pas en sortir
            sponge_km = param_config.getConfig_int("sponge_km"); // Km

            // PATH DES SORTIES HYDRO ROMS:
            directory_roms = param_config.getConfig_string("directory_roms") + region + "/";

            //directory_roms = "/Users/timbrochier/Documents/Sorties_Models/" + region + "/";
            // PECH12 :
            //directory_roms = "/Users/timbrochier/Documents/Sorties_Models/Pech12/";

            directory_Suplementary_data = param_config.getConfig_string("directory_Suplementary_data");
            main_output_directory = param_config.getConfig_string("main_output_directory");

            PonteOBS_filename = param_config.getConfig_string("PonteOBS_filename");
            PonteCLM_filename = param_config.getConfig_string("PonteCLM_filename");
            oxyclin_filename = param_config.getConfig_string("oxyclin_filename");

            Clim_chlaSeaWiFS = param_config.getConfig_string("Clim_chlaSeaWiFS");

            sufixe = param_config.getConfig_string("sufixe");

        } catch (Exception e) {
// TODO Auto-generated catch block
            System.out.println("probleme dans Lire_configuration : " + e.getMessage());
            e.printStackTrace();
        }


        // LISTE YEAR :

//        yearlist100 = new int[]{2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008 };
// sans 2000 : 
//yearlist100 = new int[]{2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008,2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008,2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008,2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008,2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008,2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008,2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008 };
yearlist100 = new int[]{2012, 2013, 2014, 2015};
      
//   PROFONDEUR DES ZONES DE PONTE POTENTIELLE :
//        prof_potentielles = new int[]{-5, -10, -15, -20, -25, -30, -35, -40, -45, -50};
        //prof_potentielles = new int[]{-5, -15};
        prof_potentielles = new int[]{-10};
    }

    void getFieldsName() {

        // Nom des variables dans le netcdf output de roms:
        strXiDim = "xi_rho";
        strEtaDim = "eta_rho";
        strZDim = "s_rho";
        strTimeDim = "time";
        strLon = "lon_rho";
        strLat = "lat_rho";
        strBathy = "h";
        strMask_rho = "mask_rho";
//        strMask_u = "mask_u";
//        strMask_v = "mask_v";
        
        strU = "u";
        strV = "v";
        strW = "w";
        strOmega = "omega";
        strZeta = "zeta";
        strTp = "temp"; //scrum_time
        strSal = "salt";
        strTime = "time";
        strKv = "AKt";
        strHBL = "hbl";

        strPn = "pn";
        strPm = "pm";
        strThetaS = "theta_s";
        strThetaB = "theta_b";
        strHc = "hc";

// PISCES :

        strDiatoms = "DIA";
        strNanoPhyto = "NANO";
        strMicroZoo = "ZOO";
        strMesoZoo = "MESO";
        strO2 = "O2";
        
        //SOMME PHYTOT ET ZOOTOT (Pedro)
        strPhytot = "PHYTOT";
        strZootot = "ZOOTOT";
        
        // integration verticale (Baye)
        strDiatoms_int = "dia_int";
        strNanoPhyto_int = "nano_int";
        strMicroZoo_int = "zoo_int";
        strMesoZoo_int = "meso_int";
        strGoc_int = "goc_int";
        strPoc_int = "poc_int";       
       
/*
// NPZD :
        strPhyto = "PHYTO";
        strZoo = "ZOO";
        strDet = "DET";
        strNO3 = "NO3";
        strCHLA = "CHLA";

        strDiatomsChl = "DCHL";
        strNanoPhytoChl = "NCHL";
*/
    }
    //---------- End of class
}

