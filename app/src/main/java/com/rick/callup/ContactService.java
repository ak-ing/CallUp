package com.rick.callup;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;

import com.rick.thridweekapp.IContactAction;
import com.rick.thridweekapp.bean.ContactBean;

/**
 * Created by Rick on 2022/7/15 17:46.
 * God bless my code!
 */
public class ContactService extends Service {

    private ContactPresenter mContactPresenter = new ContactPresenter();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        String action = intent.getAction();
        if ("com.rick.callup.CONTACT_SERVICE".equals(action)) {
            return mContactAction;
        }
        return mContactPresenter;
    }

    IContactAction.Stub mContactAction = new IContactAction.Stub() {
        @Override
        public void sendMessage(ContactBean contact) throws RemoteException {

        }

        @Override
        public void callUp(ContactBean contact) throws RemoteException {

        }
    };

    class ContactPresenter extends Binder {
        private ContactBean mContact;

        public void observe() {

        }

        public ContactBean getContact() {
            return mContact;
        }

        public void setContact(ContactBean contact) {
            mContact = contact;
        }
    }

}
