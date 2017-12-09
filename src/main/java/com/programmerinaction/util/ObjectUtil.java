package com.programmerinaction.util;

import com.programmerinaction.util.exception.BusinessException;

import java.util.Objects;
import java.util.function.*;

/**
 * Classe utilitária que contém métodos estáticos que operação sobre objeto java.
 *
 * @author <a href='http://github.com/nelsoncastro'>Nelson Castro</a>
 * @since 1.0
 */
public final class ObjectUtil {

    private ObjectUtil() {
        throw new AssertionError("No ObjectUtil instances for you!");
    }

    /**
     * <p>Executa operação sobre objeto caso o mesmo tenha uma referência válida.</p>
     *
     * @param object Referência do objeto para verificar nulidade
     * @param action Ação que será executa sobre o objeto
     * @param <T>    Tipo do objeto
     */
    public static <T> void nonNull(T object, Consumer<T> action) {
        Objects.requireNonNull(action, "action");
        if (Objects.nonNull(object))
            action.accept(object);
    }

    /**
     * <p>Verifica nulidade da referência informada, caso a mesma não seja {@code null}, uma
     * {@code BusinessException} é lancada.</p>
     *
     * @param object          Referência do objeto para verificar nulidade
     * @param messageSupplier messagem que será forncecida a uma {@code BusinessException}
     *                        quando for lançada
     * @param <T>             Tipo da referência
     */
    public static <T> void nonNull(T object, Supplier<String> messageSupplier) {
        if (Objects.nonNull(object))
            BusinessException.throwMessage(messageSupplier.get());
    }

    /**
     * <p>Executa operação sobre objeto caso o mesmo tenha uma referência inválida.</p>
     *
     * @param object Referência do objeto para verificar nulidade
     * @param action Ação que será executa sobre o objeto
     * @param <T>    Tipo da referência
     */
    public static <T> void isNull(T object, Consumer<T> action) {
        Objects.requireNonNull(action, "action");
        if (Objects.isNull(object))
            action.accept(object);
    }

    /**
     * <p>Verifica nulidade da referência informada, caso a mesma seja {@code null}, uma
     * {@code BusinessException} é lancada.</p>
     *
     * @param object          Referência do objeto para verificar nulidade
     * @param messageSupplier messagem que será forncecida a uma {@code BusinessException}
     *                        quando for lançada
     * @param <T>             Tipo da referência
     */
    public static <T> void isNull(T object, Supplier<String> messageSupplier) {
        if (Objects.isNull(object))
            BusinessException.throwMessage(messageSupplier.get());
    }

    /**
     * <p>Executa operação sobre o valor informado caso o predicado aplicado sobre a
     * referência do objeto seja {@code true}.</p>
     *
     * @param object    Referência do objeto para verificar nulidade
     * @param condition Predicado que testa objeto informado
     * @param action    Ação que será executa sobre o objeto
     * @param <T>       Tipo do objeto
     */
    public static <T> void isTrue(T object, Predicate<T> condition, Consumer<T> action) {
        Objects.requireNonNull(condition, "condition");
        Objects.requireNonNull(action, "action");
        if (condition.test(object))
            action.accept(object);
    }

    /**
     * <p>Executa operação sobre o valor informado caso o predicado aplicado sobre a
     * referência do objeto seja {@code false}.</p>
     *
     * @param object    Referência do objeto para verificar nulidade
     * @param condition Predicado que testa objeto informado
     * @param action    Ação que será executa sobre o objeto
     * @param <T>       Tipo do objeto
     */
    public static <T> void isFalse(T object, Predicate<T> condition, Consumer<T> action) {
        Objects.requireNonNull(condition, "condition");
        Objects.requireNonNull(action, "action");
        if (!condition.test(object))
            action.accept(object);
    }

    /**
     * <p>Executa operação sobre os valores informados caso o predicado aplicado sobre a
     * referências seja {@code true}.</p>
     *
     * @param a         Referência para o objeto tipo <T>
     * @param b         Referência para o objeto tipo <U>
     * @param condition Predicado que testa objeto informado
     * @param action    Ação que será executa sobre o objeto
     * @param <T>       Tipo do primeiro objeto informado
     * @param <U>       Tipo do segundo objeto informado
     */
    public static <T, U> void isTrue(T a, U b, BiPredicate<T, U> condition, BiConsumer<T, U> action) {
        Objects.requireNonNull(condition, "condition");
        Objects.requireNonNull(action, "action");
        if (condition.test(a, b))
            action.accept(a, b);
    }

    /**
     * <p>Executa operação sobre os valores informados caso o predicado aplicado sobre a
     * referências seja {@code false}.</p>
     *
     * @param a         Referência para o objeto tipo <T>
     * @param b         Referência para o objeto tipo <U>
     * @param condition Predicado que testa objeto informado
     * @param action    Ação que será executa sobre o objeto
     * @param <T>       Tipo do primeiro objeto informado
     * @param <U>       Tipo do segundo objeto informado
     */
    public static <T, U> void isFalse(T a, U b, BiPredicate<T, U> condition, BiConsumer<T, U> action) {
        Objects.requireNonNull(condition, "condition");
        Objects.requireNonNull(action, "action");
        if (!condition.test(a, b))
            action.accept(a, b);
    }

    /**
     * <p>Caso o predicate aplicado a referência do objeto seja {@code true}, uma
     * {@code BusinessException} é lancada.</p>
     *
     * @param object          Referência do objeto para verificar nulidade
     * @param messageSupplier messagem que será forncecida a uma {@code BusinessException}
     *                        quando for lançada
     * @param <T>             Tipo da referência
     */
    public static <T> void isTrue(T object, Predicate<T> condition, Supplier<String> messageSupplier) {
        Objects.requireNonNull(condition, "condition");
        if (condition.test(object))
            BusinessException.throwMessage(messageSupplier.get());
    }

    /**
     * <p>Caso o predicate aplicado a referência do objeto seja {@code false}, uma
     * {@code BusinessException} é lancada.</p>
     *
     * @param object          Referência do objeto para verificar nulidade
     * @param messageSupplier messagem que será forncecida a uma {@code BusinessException}
     *                        quando for lançada
     * @param <T>             Tipo da referência
     */
    public static <T> void isFalse(T object, Predicate<T> condition, Supplier<String> messageSupplier) {
        Objects.requireNonNull(condition, "condition");
        if (!condition.test(object))
            BusinessException.throwMessage(messageSupplier.get());
    }
}
