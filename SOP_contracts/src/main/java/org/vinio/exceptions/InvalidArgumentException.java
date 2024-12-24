package org.vinio.exceptions;

/**
 * Исключение для случаев, когда передан некорректный аргумент в запросе.
 */
public class InvalidArgumentException extends RuntimeException {

    /**
     * Конструктор с указанием подробного сообщения.
     *
     * @param message подробное описание ошибки
     */
    public InvalidArgumentException(String message) {
        super("Некорректный запрос: " + message);
    }
}
