package alex.customWidget.client;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.FocusWidget;

import java.util.ArrayList;
import java.util.List;

// класс GWT виджета
public class RatingFieldWidget extends FocusWidget {

    private static final String CLASSNAME = "ratingfield";

     // API для реакции на клики
    public interface StarClickListener {
            void starClicked(int value);
    }

    protected List<SpanElement> stars = new ArrayList<SpanElement>(5);
    protected StarClickListener listener;
    protected int value = 0;

    public RatingFieldWidget() {
        DivElement container = DOM.createDiv().cast();
        container.getStyle().setDisplay(Display.INLINE_BLOCK);
        for (int i = 0; i < 5; i++) {
            SpanElement star = DOM.createSpan().cast();

            // Добавляем элемент звезды в контейнер
            DOM.insertChild(container, star, i);
            // Подписываемся на событие ONCLICK
            DOM.sinkEvents(star, Event.ONCLICK);

            stars.add(star);
        }
        setElement(container);

        setStylePrimaryName(CLASSNAME);
    }

    // главный метод обработки событий в виджетах GWT
    @Override
    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);

        switch (event.getTypeInt()) {
            // Реагируем на события ONCLICK
            case Event.ONCLICK:
                SpanElement element = event.getEventTarget().cast();
                // только если клик по звезде
                int index = stars.indexOf(element);
                if (index >= 0) {
                    int value = index + 1;
                    // устанавливаем внутреннее значение
                    setValue(value);

                    // уведомляем интересующихся
                    if (listener != null) {
                        listener.starClicked(value);
                    }
                }
                break;
            }
    }

    // Понадобиться если на сервере зададут другой primaryStyleName
     // это часто случается при наследовании классов компонентов
    @Override
    public void setStylePrimaryName(String style) {
        super.setStylePrimaryName(style);

        for (SpanElement star : stars) {
            star.setClassName(style + "-star");
        }

        updateStarsStyle(this.value);
}

// Позволим изменять состояние стороннему коду
public void setValue(int value) {
        this.value = value;

        updateStarsStyle(value);
    }

    // обновляем визуальное представление
    private void updateStarsStyle(int value) {
            for (SpanElement star : stars) {
                star.removeClassName(getStylePrimaryName() + "-star-selected");
            }

            for (int i = 0; i < value; i++) {
                stars.get(i).addClassName(getStylePrimaryName() + "-star-selected");
            }
    }
}