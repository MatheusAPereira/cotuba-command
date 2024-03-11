package cotuba.application;

import cotuba.domain.Ebook;

public interface Command {
    public void execute(Ebook ebook);
}
