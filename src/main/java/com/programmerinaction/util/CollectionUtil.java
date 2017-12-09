package com.programmerinaction.util;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * Classe utilitária para manipulação de {@link java.util.Collection}.
 *
 * @author <a href='http://github.com/nelsoncastro'>Nelson Castro</a>
 * @since 1.0
 */
public final class CollectionUtil {

    private CollectionUtil() {
        throw new AssertionError("No CollectionUtil instances for you!");
    }

    /**
     * <p>Filtra {@link java.util.stream.Stream} com base no
     * {@link java.util.function.Predicate} informado.</p>
     *
     * @param stream    É a stream de elementos
     * @param predicate É o filtro aplicado sobre a stream
     * @return uma {@link java.util.stream.Stream}
     */
    public static <T> Stream<T> filter(Stream<T> stream, Predicate<T> predicate) {
        return requireNonNull(stream).filter(requireNonNull(predicate, "predicate"));
    }

    /**
     * <p>Filtra uma {@link java.util.Collection} com base no
     * {@link java.util.function.Predicate} informado.</p>
     *
     * @param values    É a coleção que deve ser filtrada
     * @param predicate É o filtro aplicado sobre a coleção
     * @return a coleção filtrada
     */
    public static <T> Stream<T> filter(Collection<T> values, Predicate<T> predicate) {
        return toStream(values).filter(requireNonNull(predicate, "predicate"));
    }

    /**
     * <p>Filtra uma {@link java.util.Collection} com base no
     * {@link java.util.function.Predicate} informado.</p>
     *
     * @param values    É a coleção que deve ser filtrada
     * @param predicate É o filtro aplicado sobre a coleção
     * @return uma {@link java.util.List}
     */
    public static <T> List<T> filterToList(Collection<T> values, Predicate<T> predicate) {
        return filter(values, predicate).collect(toList());
    }

    /**
     * <p>Filtra uma {@link java.util.Collection} com base no
     * {@link java.util.function.Predicate} informado.</p>
     *
     * @param values    É a coleção que deve ser filtrada
     * @param predicate É o filtro aplicado sobre a coleção
     * @return uma {@link java.util.Set}
     */
    public static <T> Set<T> filterToSet(Collection<T> values, Predicate<T> predicate) {
        return filter(values, predicate).collect(toSet());
    }

    /**
     * <p>Retorna um {@link java.util.stream.Stream} que consiste da aplicação da
     * função de filtro e mapeamento sobre os elementos da coleção informada.</p>
     *
     * @param values    É a coleção que deve ser filtrada e mapeada
     * @param predicate É o filtro aplicado sobre a coleção
     * @param mapper    É a função de mapeamento
     * @return um {@link java.util.stream.Stream}
     */
    public static <T, R> Stream<R> filterAndMap(Collection<T> values, Predicate<T> predicate, Function<T, R> mapper) {
        return filter(values, predicate).map(requireNonNull(mapper, "mapper"));
    }

    /**
     * <p>Retorna uma {@link java.util.stream.Stream} que consiste da aplicação da
     * função de mapeamento sobre os elementos da coleção informada.</p>
     *
     * @param values É a {@link java.util.stream.Stream} que deve ser mapeada
     * @param mapper É a função de mapeamento
     * @return um {@link java.util.stream.Stream}
     */
    public static <T, R> Stream<R> map(Stream<T> values, Function<T, R> mapper) {
        return requireNonNull(values).map(requireNonNull(mapper, "mapper"));
    }

    /**
     * <p>Retorna uma {@link java.util.stream.Stream} que consiste da aplicação da
     * função de mapeamento sobre os elementos da coleção informada.</p>
     *
     * @param values É a {@link java.util.stream.Stream} que deve ser mapeada
     * @param mapper É a função de mapeamento
     * @return um {@link java.util.stream.IntStream}
     */
    public static <T> IntStream mapToInt(Stream<T> values, ToIntFunction<? super T> mapper) {
        return requireNonNull(values).mapToInt(requireNonNull(mapper, "mapper"));
    }

    /**
     * <p>Retorna um {@link java.util.stream.IntStream} que consiste da aplicação da
     * função de mapeamento sobre os elementos da coleção informada.</p>
     *
     * @param values É a {@link java.util.Collection} que deve ser mapeada
     * @param mapper É a função de mapeamento
     * @return um {@link java.util.stream.IntStream}
     */
    public static <T> IntStream mapToInt(Collection<T> values, ToIntFunction<? super T> mapper) {
        return toStream(values).mapToInt(requireNonNull(mapper, "mapper"));
    }

    /**
     * <p>Retorna uma {@link java.util.stream.Stream} que consiste da aplicação da
     * função de mapeamento sobre os elementos da coleção informada.</p>
     *
     * @param values É a {@link java.util.stream.Stream} que deve ser mapeada
     * @param mapper É a função de mapeamento
     * @return um {@link java.util.stream.LongStream}
     */
    public static <T> LongStream mapToLong(Stream<T> values, ToLongFunction<? super T> mapper) {
        return requireNonNull(values).mapToLong(requireNonNull(mapper, "mapper"));
    }

    /**
     * <p>Retorna uma {@link java.util.stream.LongStream} que consiste da aplicação da
     * função de mapeamento sobre os elementos da coleção informada.</p>
     *
     * @param values É a {@link java.util.Collection} que deve ser mapeada
     * @param mapper É a função de mapeamento
     * @return um {@link java.util.stream.LongStream}
     */
    public static <T> LongStream mapToLong(Collection<T> values, ToLongFunction<? super T> mapper) {
        return toStream(values).mapToLong(requireNonNull(mapper, "mapper"));
    }

    /**
     * <p>Retorna uma {@link java.util.stream.DoubleStream} que consiste da aplicação da
     * função de mapeamento sobre os elementos da coleção informada.</p>
     *
     * @param values É a {@link java.util.stream.Stream} que deve ser mapeada
     * @param mapper É a função de mapeamento
     * @return um {@link java.util.stream.DoubleStream}
     */
    public static <T> DoubleStream mapToDouble(Stream<T> values, ToDoubleFunction<? super T> mapper) {
        return requireNonNull(values).mapToDouble(requireNonNull(mapper, "mapper"));
    }

    /**
     * <p>Retorna uma {@link java.util.stream.DoubleStream} que consiste da aplicação da
     * função de mapeamento sobre os elementos da coleção informada.</p>
     *
     * @param values É a {@link java.util.Collection} que deve ser mapeada
     * @param mapper É a função de mapeamento
     * @return um {@link java.util.stream.DoubleStream}
     */
    public static <T> DoubleStream mapToDouble(Collection<T> values, ToDoubleFunction<? super T> mapper) {
        return toStream(values).mapToDouble(requireNonNull(mapper, "mapper"));
    }

    /**
     * <p>Retorna uma {@link java.util.List} que consiste da aplicação da função de
     * mapeamento sobre os elementos da coleção informada.</p>
     *
     * @param values É a {@link java.util.stream.Stream} que deve ser mapeada
     * @param mapper É a função de mapeamento
     * @return um {@link java.util.List}
     */
    public static <T, R> List<R> mapToList(Stream<T> values, Function<T, R> mapper) {
        return map(requireNonNull(values), requireNonNull(mapper, "mapper")).collect(toList());
    }

    /**
     * <p>Retorna um {@link java.util.stream.Stream} que consiste da aplicação da
     * função de mapeamento sobre os elementos da coleção informada.</p>
     *
     * @param values É a coleção que deve ser mapeada
     * @param mapper É a função de mapeamento
     * @return um {@link java.util.stream.Stream}
     */
    public static <T, R> Stream<R> map(Collection<T> values, Function<T, R> mapper) {
        return toStream(values).map(requireNonNull(mapper, "mapper"));
    }

    /**
     * <p>Retorna uma {@link java.util.List} que consiste da aplicação da função de
     * mapeamento sobre os elementos da coleção informada.</p>
     *
     * @param values É a coleção que deve ser mapeada
     * @param mapper É a função de mapeamento
     * @return um {@link java.util.List}
     */
    public static <T, R> List<R> mapToList(Collection<T> values, Function<T, R> mapper) {
        return map(toStream(values), requireNonNull(mapper, "mapper")).collect(toList());
    }

    /**
     * <p>Retorna um {@link java.util.Set} de elementos que consiste da aplicação
     * da função de mapeamento sobre os elementos da coleção informada.</p>
     *
     * @param values É a coleção que deve ser mapeada
     * @param mapper É a função de mapeamento
     * @return um {@link java.util.Set}
     */
    public static <T, R> Set<R> mapToSet(Collection<T> values, Function<T, R> mapper) {
        return map(toStream(values), requireNonNull(mapper, "mapper")).collect(toSet());
    }

    /**
     * <p>Obtém quantidade total de registros resultantes da aplicação do filtro
     * sobre a coleção.</p>
     *
     * @param values    É a coleção que deve ser filtrada
     * @param predicate É o filtro aplicado sobre a coleção
     * @return quantidade total de registros da coleção
     */
    public static <T> long filterAndCount(Collection<T> values, Predicate<T> predicate) {
        return filter(values, predicate).count();
    }

    /**
     * <p>Obtém quantidade total de registros resultantes da aplicação do filtro
     * sobre a {@link java.util.stream.Stream}.</p>
     *
     * @param values    É a {@link java.util.stream.Stream} que deve ser filtrada
     * @param predicate É o filtro aplicado sobre a coleção
     * @return quantidade total de registros da coleção
     */
    public static <T> long filterAndCount(Stream<T> values, Predicate<T> predicate) {
        return filter(values, predicate).count();
    }

    /**
     * <p>Verifica se existe(m) registro(s) na coleção que sastifaçam o predicado informado.</p>
     *
     * @param values    É a coleção que deve ser filtrada
     * @param predicate É o filtro aplicado sobre a coleção
     * @return {@code true} caso existam registros que sastifaçam o predicado informado,
     * caso contrário, retorna {@code false}
     */
    public static <T> boolean contains(Collection<T> values, Predicate<T> predicate) {
        return filter(values, predicate).count() > 0;
    }

    /**
     * <p>Retorna o primeiro elemento resultante da aplicação do filtro sobre a
     * coleção informada.</p>
     *
     * @param values    É a coleção que deve ser filtrada
     * @param predicate É o filtro aplicado sobre a coleção
     * @return {@link java.util.Optional} do tipo da coleção
     */
    public static <T> Optional<T> findFirst(Collection<T> values, Predicate<T> predicate) {
        return filter(values, predicate).findFirst();
    }

    /**
     * <p>Retorna o qualquer elemento resultante da aplicação do filtro sobre a
     * coleção informada.</p>
     *
     * @param values    É a coleção que deve ser filtrada
     * @param predicate É o filtro aplicado sobre a coleção
     * @return {@link java.util.Optional} do tipo da coleção
     */
    public static <T> Optional<T> findAny(Collection<T> values, Predicate<T> predicate) {
        return filter(values, predicate).findAny();
    }

    /**
     * <p>Retorna o qualquer elemento resultante da aplicação do filtro sobre a
     * coleção informada.</p>
     *
     * @param values    É a coleção que deve ser filtrada
     * @param predicate É o filtro aplicado sobre a coleção
     * @return {@link java.util.Optional} do tipo da coleção
     */
    public static <T> Optional<T> findAny(Stream<T> values, Predicate<T> predicate) {
        return filter(values, predicate).findAny();
    }

    /**
     * <p>Retorna <code>true</code> caso o predicado aplicado sobre a coleção
     * encontrar algum elemento, caso contrário retorna <code>false</code>.</p>
     *
     * @param values    É a coleção que deve ser filtrada
     * @param predicate É o filtro aplicado sobre a coleção
     * @return {@code true} caso exista registro que sastifaça o predicado informado,
     * caso contrário, retorna {@code false}
     */
    public static <T> boolean anyMatch(Collection<T> values, Predicate<T> predicate) {
        return toStream(values).anyMatch(requireNonNull(predicate, "predicate"));
    }

    /**
     * <p>Retorna <code>true</code> caso o predicado aplicado sobre a coleção
     * encontrar algum elemento, caso contrário retorna <code>false</code>.</p>
     *
     * @param values    É a {@link java.util.stream.Stream} que deve ser filtrada
     * @param predicate É o filtro aplicado sobre a coleção
     * @return {@code true} caso exista algum registro que sastifaça o predicado informado,
     * caso contrário, retorna {@code false}
     */
    public static <T> boolean anyMatch(Stream<T> values, Predicate<T> predicate) {
        return requireNonNull(values).anyMatch(requireNonNull(predicate, "predicate"));
    }

    /* private methods */

    /**
     * <p>Obtém {@link java.util.stream.Stream} de {@link java.util.Collection}.</p>
     *
     * @param values Coleção de tipos <T>
     * @param <T>    Tipo
     * @return {@link java.util.stream.Stream} de <T>
     */
    private static <T> Stream<T> toStream(Collection<T> values) {
        return requireNonNull(values).stream();
    }
}
