/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evolution;

/**
 *
 * @author timbrochier, 
 * Parametres estimes par Jorge Flores septembre 2022
 */

public class Engraulis_ringens extends DebLayer{

    public Engraulis_ringens() {
// para tiré de Engraulis_ringens_01.1.9_chile_fishbase
// (Arturo Guirre)
        // CONDITIONS INITIALES
        E_init = 0.99; // J, Initial Reserve = egg
        V_init = 0.0000001; // cm^3, Initial volume --> close to 0, try different initial values

//Primary parameters        
        // temperature correction
        T_ref = 16 + 273.15;   //  K, Reference temperature ; 
        T_A = 10000;       //  K, Arrhenius temperature ;
        T_AL = 20000;      //  K, Arrhenius temp for lower boundary


// (case 1 - Floreset al 2022
        T_L = 6 + 273.15;    //  K, lower boundary tolerance range
        T_H = 24 + 273.15;   //  K, upper boundary tolerance range
        T_AH = 570000;     //  K, Arrhenius temp for upper boundary

// (case 2 - Floreset al 2022
//        T_L = 6 + 273.15;    //  K, lower boundary tolerance range
//        T_H = 21 + 273.15;   //  K, upper boundary tolerance range
//        T_AH = 95000;     //  K, Arrhenius temp for upper boundary

       
        p_Am = 53;     // J/cm^2/d, maximum surface-specific assimilation rate
        
// mobilisation, maintenance, growth & reproduction
        v = 0.02572;  // cm/d, energy conductance
        Kappa = 0.552;       // -, allocation fraction to soma = growth + somatic maintenance
        kap_R = 0.95;         // -, reproduction efficiency
        p_M = 50.34;          // J/d.cm^3, [p_M], vol-specific somatic maintenance
        k_J = 0.0012;          // 1/d, maturity maint rate coefficient
        E_G = 5283;          // J/cm^3, [E_G], spec cost for structure

        // life stages: E_H is the cumulated energy from reserve invested in maturation
        E_Hb = 0.3889;  // J, E_H^b, maturity at birth "Calibration by Hand" (Gatti et al. 2016)       
        E_Hj = 83.22;       // J, E_H^j, maturity at metamorphosis
        E_Hp = 42160;  // J, E_H^p, maturity at puberty

        // param to compute observable quantities
        del_M = 0.1889;    //  -, shape coefficient to convert vol-length to physical length
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

        // STAGES-SPECIFIC parameters:
         del_M_egg = del_M; // shape coefficient for EGG
         T_L_egg = T_L;    //  K, lower boundary tolerance range
         T_H_egg = T_L;  //  K, upper boundary tolerance range

            del_M_YOLK_SAC_LARVA = del_M; // shape coefficient for YOLK_SAC_LARVA
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

