package fes.jonathan.iniciodesesionv1.services;

import java.util.Date;

import fes.jonathan.iniciodesesionv1.models.TokenModel;
import fes.jonathan.iniciodesesionv1.models.InicioDeSesionModel;

public class SesionService {
    public TokenModel iniciarSesion(InicioDeSesionModel inicioDeSesionModel){
     if (inicioDeSesionModel.getUsuario().equals("john@gmail")&&inicioDeSesionModel.getContrasena().equals("123456")){
         TokenModel tokenModel=new TokenModel("Token",new Date());
         return tokenModel;
     } else {
         return null;

     }
    }
}
