package io.github.dsh105.echopet.api.event;

import org.bukkit.command.CommandSender;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Called when this plugin attempts to send a message to a {@link org.bukkit.command.CommandSender}. Plugin prefix is appended automatically.
 */

public class EchoPetSendMessageEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled = false;

    private String messageToSend;
    private CommandSender recipient;

    public EchoPetSendMessageEvent(String messageToSend, CommandSender recipient) {
        this.messageToSend = messageToSend;
        this.recipient = recipient;
    }

    /**
     * Returns the message to be sent
     *
     * @return Message to be sent
     */
    public String getMessageToSend() {
        return messageToSend;
    }

    /**
     * Sets the message to be sent
     *
     * @param messageToSend New message to be sent
     */
    public void setMessageToSend(String messageToSend) {
        this.messageToSend = messageToSend;
    }

    /**
     * Gets the recipient of the message
     *
     * @return Recipient of the message
     */
    public CommandSender getRecipient() {
        return recipient;
    }

    /**
     * Sets the recipient of the message
     *
     * @param recipient {@link org.bukkit.command.CommandSender} who will receive the message
     */
    public void setRecipient(CommandSender recipient) {
        this.recipient = recipient;
    }

    /**
     * Gets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins
     *
     * @return true if this event is cancelled
     */
    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Sets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins
     *
     * @param cancel true if you wish to cancel this event
     */

    @Override
    public HandlerList getHandlers() {
        return this.handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}