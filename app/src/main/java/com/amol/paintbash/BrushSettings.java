package com.amol.paintbash;

import android.util.DisplayMetrics;

interface BrushSettings {
  void init(DisplayMetrics dM);

  void setSize(float size);

  void setColor(int color);

  void normal();

  void blur();

  void clear();

  void emboss();
}
