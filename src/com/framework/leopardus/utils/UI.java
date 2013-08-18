package com.framework.leopardus.utils;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.framework.leopardus.interfaces.ActivityMethodInterface;

public class UI {
	public static void dialogYesNo(final Activity c, final String message,
			final ActivityMethodInterface onYes,
			final ActivityMethodInterface onNo) {
		DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				switch (which) {
				case DialogInterface.BUTTON_POSITIVE:
					onYes.Method(c);
					break;

				case DialogInterface.BUTTON_NEGATIVE:
					onNo.Method(c);
					break;
				}
			}
		};
		AlertDialog.Builder builder = new AlertDialog.Builder(c);
		builder.setMessage(message)
				.setPositiveButton(c.getString(R.string.yes),
						dialogClickListener)
				.setNegativeButton(c.getString(R.string.no),
						dialogClickListener).show();
	}
}
