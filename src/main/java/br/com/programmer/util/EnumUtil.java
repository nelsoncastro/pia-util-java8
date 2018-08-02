/*
 * NELSON PERIRA DE CASTRO
 * Copyright 2018, NELSON PEREIRA DE CASTRO, 
 * and individual contributors as indicated by the @authors tag
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package br.com.programmer.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Objects.isNull;

/**
 * Classe utilitária para manipulação de tipos {@link Enum}.
 *
 * @author <a href='http://github.com/nelsoncastro'>Nelson Castro</a>
 * @since 1.0
 */
public final class EnumUtil {

    private EnumUtil() {
        throw new AssertionError("No EnumUtil instances for you!");
    }

    /**
     * <p>Recupera um {@link java.util.stream.Stream} de um tipo {@link Enum}
     * informado.</p>
     *
     * @param enumType É o tipo {@link Enum}
     * @return {@link java.util.stream.Stream} de um {@link Enum}
     */
    public static <T extends Enum<T>> Stream<T> toStream(Class<T> enumType) {
        enumTypeValidate(enumType);
        return Stream.of(enumType.getEnumConstants());
    }

    /**
     * <p>Recupera um {@link java.util.Map} de um tipo {@link Enum} informado.</p>
     *
     * @param enumType É o tipo {@link Enum}
     * @return {@link java.util.Map} de um {@link Enum}
     */
    public static <T extends Enum<T>> Map<Integer, String> toMap(Class<T> enumType) {
        enumTypeValidate(enumType);
        return Stream.of(enumType.getEnumConstants()).collect(Collectors.toMap(Enum::ordinal, Enum::name));
    }

    /**
     * <p>Recupera uma {@link java.util.List} de um tipo {@link Enum}
     * informado.</p>
     *
     * @param enumType É o tipo {@link Enum}
     * @return {@link java.util.List} de um {@link Enum}
     */
    public static <T extends Enum<T>> List<T> toList(Class<T> enumType) {
        enumTypeValidate(enumType);
        return Arrays.asList(enumType.getEnumConstants());
    }

    /**
     * <p>Recupera uma {@link java.util.List} ordenada de um tipo {@link Enum}
     * informado.</p>
     *
     * @param enumType É o tipo {@link Enum}
     * @return {@link java.util.List} de um {@link Enum}
     */
    public static <T extends Enum<T>> List<T> toSortedList(Class<T> enumType) {
        enumTypeValidate(enumType);
        return sort(Arrays.asList(enumType.getEnumConstants()));
    }

    /**
     * <p>Faz a ordenadação de uma {@link java.util.List}.</p>
     *
     * @param list É a {@link java.util.List} que deverá ser ordenada
     * @return {@link java.util.List} ordenada
     */
    private static <T extends Enum<T>> List<T> sort(List<T> list) {
        if (isNull(list) || list.isEmpty())
            return list;
        list.sort(comparing(Enum::name));
        return list;
    }

    /**
     * <p>Valida se tipo Enum é válido.</p>
     *
     * @param enumType É o tipo {@link Enum} a ser validado
     */
    private static <T extends Enum<T>> void enumTypeValidate(Class<T> enumType) {
        if (isNull(enumType))
            throw new IllegalArgumentException("\"enumType\" argument is invalid");
    }
}
