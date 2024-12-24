package org.vinio.exceptions;

/**
 * Исключение для случаев, когда запись в БД с переданным id Не найдена
 */
public class RecordNotFoundException extends RuntimeException {
    /**
     * Конструктор с указанием подробного сообщения.
     *
     * @param message подробное описание ошибки
     */
    public RecordNotFoundException(String message) {
        super(message);
    }
}