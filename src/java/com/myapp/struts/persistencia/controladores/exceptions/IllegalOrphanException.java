package com.myapp.struts.persistencia.controladores.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class IllegalOrphanException extends Exception {
    private List<String> messages;

    /**
     *
     * @param messages
     */
    public IllegalOrphanException(List<String> messages) {
        super((messages != null && messages.size() > 0 ? messages.get(0) : null));
        if (messages == null) {
            this.messages = new ArrayList<String>();
        }
        else {
            this.messages = messages;
        }
    }

    /**
     *
     * @return
     */
    public List<String> getMessages() {
        return messages;
    }
}
