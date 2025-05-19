const baseTheme = {
  radius: {
    small: '0.25rem',
    medium: '0.5rem',
    large: '0.75rem',
    xl: '1rem',
    full: '9999px',
  },
  transitions: {
    fast: '0.15s ease',
    default: '0.3s ease',
    slow: '0.5s ease',
  },
  shadows: {
    sm: '0 1px 2px 0 rgba(0, 0, 0, 0.05)',
    md: '0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px rgba(0, 0, 0, 0.06)',
    lg: '0 10px 15px -3px rgba(0, 0, 0, 0.1), 0 4px 6px -2px rgba(0, 0, 0, 0.05)',
    xl: '0 20px 25px -5px rgba(0, 0, 0, 0.1), 0 10px 10px -5px rgba(0, 0, 0, 0.04)',
  },
  spacing: {
    '0': '0',
    '1': '0.25rem',
    '2': '0.5rem',
    '3': '0.75rem',
    '4': '1rem',
    '5': '1.25rem',
    '6': '1.5rem',
    '8': '2rem',
    '10': '2.5rem',
    '12': '3rem',
    '16': '4rem',
    '20': '5rem',
    '24': '6rem',
    '32': '8rem',
    '40': '10rem',
    '48': '12rem',
  },
  fontSizes: {
    xs: '0.75rem',
    sm: '0.875rem',
    md: '1rem',
    lg: '1.125rem',
    xl: '1.25rem',
    '2xl': '1.5rem',
    '3xl': '1.875rem',
    '4xl': '2.25rem',
    '5xl': '3rem',
  },
  fontWeights: {
    light: 300,
    normal: 400,
    medium: 500,
    semibold: 600,
    bold: 700,
  },
  sizes: {
    sidebar: {
      expanded: '240px',
      collapsed: '80px',
    },
  },
};

export const darkTheme = {
...baseTheme,
colors: {
  background: '#151923',
  foreground: '#f8f9fa',
  
  primary: '#AFD2E9',
  primaryForeground: '#37718E',
  
  secondary: '#2a2f3d',
  secondaryForeground: '#f8f9fa',

  brand: '#AFD2E9',
  brandPress: '#37718E',
  
  card: '#1d2230',
  cardForeground: '#f8f9fa',
  
  border: 'rgba(255, 255, 255, 0.1)',
  borderActive: 'rgba(255, 255, 255, 0.2)',
  
  muted: '#2a2f3d',
  mutedForeground: '#a1a1aa',
  
  accent: '#FC9C1C',
  accentForeground: '#151923',

  success: '#20c55e',
  successForeground: '#183b2f',

  warning: '#cc8417',
  warningForeground: '#40381e',

  error: '#e33c3a',
  errorForeground: '#41222a',
  
  destructive: '#ef4444',
  destructiveForeground: '#f8f9fa',
  inputBackground: '#0f1729',
  dialogBackground: '#1d2230',
  popoverBackground: '#0f1729',
  // Sidebar specific
  sidebar: {
    background: '#0f111a',
    foreground: '#f8f9fa',
    accent: '#2a2f3d',
    accentForeground: '#f8f9fa',
    border: 'rgba(255, 255, 255, 0.1)',
    primary: '#FC9C1C',
    primaryForeground: '#151923',
  },
},
};

export const lightTheme = {
...baseTheme,
colors: {
  background: '#ffffff',
  foreground: '#111827',
  
  primary: '#FC9C1C',
  primaryForeground: '#ffffff',
  
  secondary: '#f3f4f6',
  secondaryForeground: '#111827',

  brand: '#fc9c1c',
  brandPress: '#e88200',
  
  card: '#ffffff',
  cardForeground: '#111827',
  
  border: 'rgba(0, 0, 0, 0.1)',
  borderActive: 'rgba(0, 0, 0, 0.2)',
  
  muted: '#f3f4f6',
  mutedForeground: '#6b7280',
  
  accent: '#FC9C1C',
  accentForeground: '#ffffff',

  success: '#22c573',
  successForeground: '#d3f3df',

  warning: '#eeb908',
  warningForeground: '#fbf0ce',

  error: '#f06f8c',
  errorForeground: '#fcdada',
  
  destructive: '#ef4444',
  destructiveForeground: '#ffffff',
  inputBackground: '#ffffff',
  dialogBackground: '#ffffff',
  popoverBackground: '#ffffff',

  sidebar: {
    background: '#f8f9fa',
    foreground: '#111827',
    accent: '#f3f4f6',
    accentForeground: '#111827',
    border: 'rgba(0, 0, 0, 0.1)',
    primary: '#FC9C1C',
    primaryForeground: '#ffffff',
  },
},
};

export type Theme = typeof darkTheme;