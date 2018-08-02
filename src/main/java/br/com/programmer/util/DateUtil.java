/*
 * NELSON PEREIRA DE CASTRO
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

/**
 * Classe utilitária para manipulação de data/hora.
 *
 * @author <a href='http://github.com/nelsoncastro'>Nelson Castro</a>
 * @since 1.0
 */
public final class DateUtil {

    private DateUtil() {
        throw new AssertionError("No DateUtil instances for you!");
    }

    /**
     * <p>Converte {@link java.util.Date} em {@link java.time.LocalDate}</p>
     * <p>
     * java.sql.Date não suporta a conversão direta para Instant, para tal,
     * convertendo de Calendar para Instant.
     * </p>
     *
     * @param date {@link java.util.Date} a ser convertido
     * @return {@link java.time.LocalDate}
     */
    public static LocalDate dateToLocalDate(Date date) {
        requireNonNull(date, "date");
        return buildCalendar(date).getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * <p>Converte {@link java.util.Date} em {@link java.time.LocalDateTime}.</p>
     *
     * @param date {@link java.util.Date} a ser convertido
     * @return {@link java.time.LocalDateTime}
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        requireNonNull(date, "date");
        return buildCalendar(date).getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * <p>Converte {@link java.time.LocalDate} em {@link java.util.Date}.</p>
     *
     * @param localDate {@link java.time.LocalDate} a ser convertido
     * @return {@link java.util.Date}
     */
    public static Date localDateToDate(LocalDate localDate) {
        requireNonNull(localDate, "localDate");
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * <p>Converte {@link java.time.LocalDateTime} em {@link java.util.Date}.</p>
     *
     * @param localDateTime {@link java.time.LocalDate} a ser convertido
     * @return {@link java.util.Date}
     */
    public static Date localDataTimeToDate(LocalDateTime localDateTime) {
        requireNonNull(localDateTime, "localDateTime");
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * <p>
     * Formata data no estilo completo, com o maior número de detalhes. Ex: Quarta-feira, 1 de Novembro de 2017.
     * </p>
     *
     * @param localDate Data a ser formatada
     * @return data formatada
     */
    public static String formatDateWithFullStyle(LocalDate localDate) {
        return formatLocalDate(localDate, FormatStyle.FULL);
    }

    /**
     * <p>
     * Formata data no estilo DD de MM de YYYY. Ex: 1 de Novembro de 2017.
     * </p>
     *
     * @param localDate Data a ser formatada
     * @return data formatada
     */
    public static String formatDateWithLongStyle(LocalDate localDate) {
        return formatLocalDate(localDate, FormatStyle.LONG);
    }

    /**
     * <p>
     * Formata data no estilo DD/MM/YYYY. Ex: 01/11/2017.
     * </p>
     *
     * @param localDate Data a ser formatada
     * @return data formatada
     */
    public static String formatDateWithMediumStyle(LocalDate localDate) {
        return formatLocalDate(localDate, FormatStyle.MEDIUM);
    }

    /**
     * <p>
     * Formata data no estilo dd/MM/yy. Ex: 01/11/17.
     * </p>
     *
     * @param localDate Data a ser formatada
     * @return data formatada
     */
    public static String formatDateWithShortStyle(LocalDate localDate) {
        return formatLocalDate(localDate, FormatStyle.SHORT);
    }

    /**
     * <p>
     * Formata data/hora no estilo dd/MM/yyyy hh:mm. Ex: 01/11/2017 17:02
     * </p>
     *
     * @param localDateTime Data/hora a ser formatada
     * @return data/hora formatada
     */
    public static String formatDateTimeShortStyle(LocalDateTime localDateTime) {
        return formatLocalDateTime(localDateTime, FormatStyle.SHORT);
    }

    /**
     * <p>
     * Formata data/hora no estilo dd/MM/yyyy hh:mm:ss. Ex: 01/11/2017 17:02:36
     * </p>
     *
     * @param localDateTime Data/hora a ser formatada
     * @return data/hora formatada
     */
    public static String formatDateTimeMediumStyle(LocalDateTime localDateTime) {
        return formatLocalDateTime(localDateTime, FormatStyle.MEDIUM);
    }

    /* private methods */

    /**
     * <p>Formata data/hora com o estilo de formato informado.</p>
     *
     * @param localDateTime Data/hora a ser formatada
     * @param style         Estilo de formato
     * @return data/hora formata
     */
    private static String formatLocalDateTime(LocalDateTime localDateTime, FormatStyle style) {
        requireNonNull(localDateTime, "localDate");
        requireNonNull(style, "style");
        return localDateTime.format(DateTimeFormatter.ofLocalizedDate(style).withLocale(getDefaultLocale()));
    }

    /**
     * <p>Formata data com o estilo de formato informado.</p>
     *
     * @param localDate Data a ser formatada
     * @param style     Estilo de formato
     * @return data formata
     */
    private static String formatLocalDate(LocalDate localDate, FormatStyle style) {
        requireNonNull(localDate, "localDate");
        requireNonNull(style, "style");
        return localDate.format(DateTimeFormatter.ofLocalizedDate(style).withLocale(getDefaultLocale()));
    }

    /**
     * <p>Cria um {@link java.util.Calendar} com base em um {@link java.util.Date}.</p>
     *
     * @param date {@link java.util.Date}
     * @return {@link java.util.Calendar}
     */
    private static Calendar buildCalendar(Date date) {
        Calendar calendar = getCalendar(null);
        calendar.setTime(date);
        return calendar;
    }

    /**
     * <p>Cria um {@link java.util.Calendar} para a área geográfica informada (Locale).</p>
     *
     * @param locale
     * @return
     */
    private static Calendar getCalendar(Locale locale) {
        return nonNull(locale) ? Calendar.getInstance(locale) : Calendar.getInstance();
    }

    /**
     * <p>Obtém Locale atual da JVM. Caso o Locale padrão seja {@code null} . </p>
     *
     * @return {@link Locale}
     */
    private static Locale getDefaultLocale() {
        return new Locale("pt", "br");
    }

}
