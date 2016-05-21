package net.feheren_fekete.stickynoteswidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;


public class QuotesWidgetProvider extends AppWidgetProvider {

    private static final String TAG = QuotesWidgetProvider.class.getSimpleName();

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        for (int widgetId : appWidgetIds) {
            updateWidget(context, appWidgetManager, widgetId, "Dummy quote");
        }
    }

    public static void updateWidget(Context context,
                                    AppWidgetManager appWidgetManager,
                                    int widgetId,
                                    String quoteText) {
        RemoteViews remoteViews = new RemoteViews(
                context.getPackageName(), R.layout.quote_widget);
        remoteViews.setTextViewText(R.id.text_view, quoteText);

        Intent intent = new Intent(context, QuotesActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.linear_layout, pendingIntent);

        appWidgetManager.updateAppWidget(widgetId, remoteViews);
    }

}
