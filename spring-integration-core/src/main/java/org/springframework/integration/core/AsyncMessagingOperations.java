package org.springframework.integration.core;

import java.util.concurrent.Future;

import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;

@Weave(type=MatchType.Interface)
public abstract class AsyncMessagingOperations {

	@Trace
	public abstract Future<?> asyncSend(Message<?> message);

	@Trace
	public abstract Future<?> asyncSend(MessageChannel channel, Message<?> message);

	@Trace
	public abstract Future<?> asyncSend(String channelName, Message<?> message);

	@Trace
	public abstract Future<?> asyncConvertAndSend(Object message);

	@Trace
	public abstract Future<?> asyncConvertAndSend(MessageChannel channel, Object message);

	@Trace
	public abstract Future<?> asyncConvertAndSend(String channelName, Object message);

	@Trace
	public abstract Future<Message<?>> asyncReceive();

	@Trace
	public abstract Future<Message<?>> asyncReceive(PollableChannel channel);

	@Trace
	public abstract Future<Message<?>> asyncReceive(String channelName);

	@Trace
	public abstract <R> Future<R> asyncReceiveAndConvert();

	@Trace
	public abstract <R> Future<R> asyncReceiveAndConvert(PollableChannel channel);

	@Trace
	public abstract <R> Future<R> asyncReceiveAndConvert(String channelName);

	@Trace
	public abstract Future<Message<?>> asyncSendAndReceive(Message<?> requestMessage);

	@Trace
	public abstract Future<Message<?>> asyncSendAndReceive(MessageChannel channel, Message<?> requestMessage);

	@Trace
	public abstract Future<Message<?>> asyncSendAndReceive(String channelName, Message<?> requestMessage);

	@Trace
	public abstract <R> Future<R> asyncConvertSendAndReceive(Object request);

	@Trace
	public abstract <R> Future<R> asyncConvertSendAndReceive(MessageChannel channel, Object request);

	@Trace
	public abstract <R> Future<R> asyncConvertSendAndReceive(String channelName, Object request);

	@Trace
	public abstract <R> Future<R> asyncConvertSendAndReceive(Object request, MessagePostProcessor requestPostProcessor);

	@Trace
	public abstract <R> Future<R> asyncConvertSendAndReceive(MessageChannel channel, Object request, MessagePostProcessor requestPostProcessor);

	@Trace
	public abstract <R> Future<R> asyncConvertSendAndReceive(String channelName, Object request, MessagePostProcessor requestPostProcessor);

}
