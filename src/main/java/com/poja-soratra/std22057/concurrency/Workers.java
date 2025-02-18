package com.poja-soratra.std22057.concurrency;

import com.poja-soratra.std22057.PojaGenerated;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static com.poja-soratra.std22057.concurrency.ThreadRenamer.getRandomSubThreadNamePrefixFrom;
import static com.poja-soratra.std22057.concurrency.ThreadRenamer.renameThread;
import static java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor;
import static java.lang.Thread.currentThread;

@PojaGenerated
@Component
public class Workers<T> {
    private final ExecutorService executorService;

    public Workers() {
        this.executorService = newVirtualThreadPerTaskExecutor();
    }

    @SneakyThrows
    public List<Future<T>> invokeAll(List<Callable<T>> callables) {
        var parentThread = currentThread();
        callables = callables.stream().map(c -> (Callable<T>) () -> {
            renameThread(currentThread(), getRandomSubThreadNamePrefixFrom(parentThread));
            return c.call();
        }).toList();
        return executorService.invokeAll(callables);
    }
}
