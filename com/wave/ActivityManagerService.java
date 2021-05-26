
package com.wave;


public class ActivityManagerService{


    private void start() {

        Launcher.main(new String[] {ActivityManagerService.class.getName()});
        System.out.println("start ");
    }


    public static final class Lifecycle extends SystemService {
        private final ActivityManagerService mService;

        public Lifecycle( ) {
            super( );
            mService = new ActivityManagerService( );
        }

        public void onStart() {
            mService.start();
        }



        public ActivityManagerService getService() {
            return mService;
        }
    }
}