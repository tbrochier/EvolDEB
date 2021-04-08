/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evolution;

/**
 *
 * @author timbrochier
 */

public class Engraulis_ringens extends DebLayer{

    public Engraulis_ringens() {
// para tiré de Engraulis_ringens_01.1.9_chile_fishbase
// (Arturo Guirre)
        // CONDITIONS INITIALES
        E_init = 2.58; // J, Initial Reserve = egg
//        E_init = 1.11; // J, Initial Reserve = egg (Gatti et al. 2016)
        V_init = 0.001; // cm^3, Initial volume --> close to 0, try different initial values
        // taille d'un oeuf = 1 mm3

//Primary parameters        
        // temperature correction
        T_ref = 293.1;   //  K, Reference temperature ; 
        T_A = 8000;       //  K, Arrhenius temperature ;
        T_AL = 50000;      //  K, Arrhenius temp for lower boundary
        T_AH = 190000;     //  K, Arrhenius temp for upper boundary

// GAMME MIN-MAX DE TEMP ICI CELLE DES ADULTES INDICATIF,
        //MAIS CHANGE POUR CHAQUE STADE (dans set_stage):
            // Min et Max des corr de flux de temperature pour JUVENILES:
            T_L = 0 + 273;    //  K, lower boundary tolerance range
            T_H = 26 + 273;   //  K, upper boundary tolerance range

       
        // feeding & assimilation
        F_m = 6.5;    // l/d.cm^2, {F_m} max spec searching rate
        kap_X = 0.8;   // -, digestion efficiency of food to reserve

        // -> S. pilachardus : 
        p_Am = 1.677 * 92.51 / 0.3436 * 2.4019;     // J/cm^2/d, maximum surface-specific assimilation rate
        
// mobilisation, maintenance, growth & reproduction
        v = 0.02953;  // cm/d, energy conductance
        Kappa = 0.2342;       // -, allocation fraction to soma = growth + somatic maintenance
        kap_R = 0.95;         // -, reproduction efficiency
        p_M = 82.22;          // J/d.cm^3, [p_M], vol-specific somatic maintenance
        p_T = 0;              // J/d.cm^2, {p_T}, surface-specific som maintenance
        k_J = 0.002;          // 1/d, maturity maint rate coefficient
        E_G = 5216;          // J/cm^3, [E_G], spec cost for structure

        // life stages: E_H is the cumulated energy from reserve invested in maturation
        E_Hh = 1;        // J, E_H^h, maturity at hatching
        E_Hb = 0.7172;  // J, E_H^b, maturity at birth "Calibration by Hand" (Gatti et al. 2016)       
        E_Hj = 3.677;       // J, E_H^j, maturity at metamorphosis
        E_Hp = 9.611e4;  // J, E_H^p, maturity at puberty

        // param to compute observable quantities
        del_M = 0.1145;    //  -, shape coefficient to convert vol-length to physical length
        d_V = 0.2; 	   // g/cm^3, specific density of structure (dry weight)
        mu_V = 500000;    // J/mol, specific chemical potential of structure
        mu_E = 550000;    // J/mol, specific chemical potential of reserve
        w_V = 23.9;      // g/mol, molecular weight of structure
        w_E = 23.9;     // g/mol, molecular weight of reserve
        c_w = 1 - d_V;   // - , water content (c_w * W_w = total water weight)
        relative_fecondity = 400; // nb oeuf par grammes (cf Gatti et al. 2016)

        // compound parameters
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        X_K = Simulation.food_half_saturation; // 0.2 = bon pour le Nano_phyto en surface //(p_Am / (kap_X * F_m))/100;// c'etait 50  // same unit as food, half-saturation coefficient
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        p_Xm = p_Am / kap_X; // J.cm-2.d-1, max surf area specific ingestion rate, here we assume constant assimilation efficiency



        // STAGES-SPECIFIC parameters:
         del_M_egg = 0.8364; // shape coefficient for EGG
         T_L_egg = T_L;    //  K, lower boundary tolerance range
         T_H_egg = T_L;  //  K, upper boundary tolerance range

            del_M_YOLK_SAC_LARVA = 0.8364; // shape coefficient for YOLK_SAC_LARVA
            T_L_YOLK_SAC_LARVA = T_L;//0 + 273;    //  K, lower boundary tolerance range
            T_H_YOLK_SAC_LARVA = T_H;//27 + 273;   //  K, upper boundary tolerance range
                
            del_M_FEEDING_LARVA = del_M;// shape coefficient for FEEDING_LARVA
            T_L_FEEDING_LARVA = T_L;    //  K, lower boundary tolerance range
            T_H_FEEDING_LARVA = T_H;//27 + 273;   //  K, upper boundary tolerance range
               
            del_M_JUVENILE = del_M;// shape coefficient for JUVENILE
            T_L_JUVENILE = T_L;    //  K, lower boundary tolerance range
            T_H_JUVENILE = T_H;//27 + 273;   //  K, upper boundary tolerance range
            
            del_M_ADULT = del_M;// shape coefficient for ADULT
            T_L_ADULT = T_L;   //  K, lower boundary tolerance range
            T_H_ADULT = T_H;//27 + 273;   //  K, upper boundary tolerance range
 
    
    
    
    }
        
}

