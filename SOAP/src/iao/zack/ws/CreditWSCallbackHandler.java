
/**
 * CreditWSCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */

    package iao.zack.ws;

    /**
     *  CreditWSCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class CreditWSCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public CreditWSCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public CreditWSCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for calculDuree method
            * override this method for handling normal response from calculDuree operation
            */
           public void receiveResultcalculDuree(
                    iao.zack.ws.CreditWSStub.CalculDureeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from calculDuree operation
           */
            public void receiveErrorcalculDuree(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for calculMensualite method
            * override this method for handling normal response from calculMensualite operation
            */
           public void receiveResultcalculMensualite(
                    iao.zack.ws.CreditWSStub.CalculMensualiteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from calculMensualite operation
           */
            public void receiveErrorcalculMensualite(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for calculCapital method
            * override this method for handling normal response from calculCapital operation
            */
           public void receiveResultcalculCapital(
                    iao.zack.ws.CreditWSStub.CalculCapitalResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from calculCapital operation
           */
            public void receiveErrorcalculCapital(java.lang.Exception e) {
            }
                


    }
    