package org.teemyroom.yontaverse.place.application;

import org.teemyroom.yontaverse.common.exception.BaseException;

public class PreviousPlaceNotClearedException extends BaseException {
    public PreviousPlaceNotClearedException() { super("아직 이 곳에 들어갈 수 없습니다. 적절한 순서에 따라 들어가세요"); }

    public PreviousPlaceNotClearedException(String message) { super(message); }
}
