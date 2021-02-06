/*
 * Copyright (c) 2010-2021 Mark Allen, Norbert Bartels.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.restfb.types.send;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.restfb.Facebook;
import com.restfb.exception.FacebookPreconditionException;
import com.restfb.types.AbstractFacebookType;

import lombok.Getter;
import lombok.Setter;

public class ListViewElement extends AbstractFacebookType {

  @Getter
  @Facebook
  private String title;

  @Getter
  @Setter
  @Facebook
  private String subtitle;

  @Getter
  @Setter
  @Facebook("image_url")
  private String imageUrl;

  @Getter
  @Setter
  @Facebook("default_action")
  private DefaultAction defaultAction;

  @Facebook
  private List<AbstractButton> buttons;

  public ListViewElement(String title) {
    this.title = title;
  }

  public boolean addButton(AbstractButton button) {
    if (buttons == null) {
      buttons = new ArrayList<>();
    }

    if (buttons.size() == 1) {
      throw new FacebookPreconditionException("maximum of associated buttons is 1");
    }

    return buttons.add(button);
  }

  public List<AbstractButton> getButtons() {
    if (buttons == null) {
      return Collections.emptyList();
    }
    return Collections.unmodifiableList(buttons);
  }
}
